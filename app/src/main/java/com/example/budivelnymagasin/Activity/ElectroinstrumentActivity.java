package com.example.budivelnymagasin.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.budivelnymagasin.R;
import com.example.budivelnymagasin.Utils.Adapter;
import com.example.budivelnymagasin.Utils.Product;
import com.example.budivelnymagasin.Utils.ProductApiRetrofit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ElectroinstrumentActivity extends AppCompatActivity {

    private Adapter mAdapter;

    private RecyclerView mNumbersList;

    static Bitmap noImageBitmap ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mNumbersList = findViewById(R.id.rv_numbers);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://budmagas.herokuapp.com/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductApiRetrofit productApiRetrofit = retrofit.create(ProductApiRetrofit.class);


        Observable<List<Product>> productObservable = productApiRetrofit.getProductsObservableElectroinstrument();

        final int[] ii = {0};

        productObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((List<Product> s) -> {
                            System.out.println(s.get(0).getName());

                            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                            mNumbersList.setLayoutManager(layoutManager);
                            mAdapter = new Adapter(s);
                            mNumbersList.setAdapter(mAdapter);
                            mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                                                                     @Override
                                                                     public void onChanged() {
                                                                         super.onChanged();
                                                                     }
                                                                 }
                            );


                            Observable<Bitmap> productObservableImage = Observable.create(img -> {

                                for (Product g : s)

                                    img.onNext(getBitmap("https://budmagas.herokuapp.com/get-image?image=" + g.getImage()));


                            });

                            productObservableImage.subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<Bitmap>() {
                                                   @Override
                                                   public void onSubscribe(@NonNull Disposable d) {

                                                   }

                                                   @Override
                                                   public void onNext(@NonNull Bitmap bitmap) {

                                                       s.get(ii[0]).setImageBitmap(bitmap);
                                                       mAdapter.notifyDataSetChanged();
                                                       ii[0]++;

                                                   }

                                                   @Override
                                                   public void onError(@NonNull Throwable e) {

                                                       e.printStackTrace();

                                                   }

                                                   @Override
                                                   public void onComplete() {
                                                   }
                                               }
                                    );

                        },
                        (Throwable::printStackTrace));
    }



    public static Bitmap getBitmap(String url) throws IOException {
        try {

            InputStream is = (InputStream) new URL(url).getContent();



            return BitmapFactory.decodeStream(is);
        } catch (Exception e) {

            return noImageBitmap;
        }
    }
}
