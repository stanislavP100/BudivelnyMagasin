//package com.example.budivelnymagasin.Activity.SecondActivity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.os.Bundle;
//
//import com.example.budivelnymagasin.R;
//import com.example.budivelnymagasin.Utils.Adapter;
//import com.example.budivelnymagasin.Utils.JsonUtils;
//import com.example.budivelnymagasin.Utils.NetworkUtils;
//import com.example.budivelnymagasin.Utils.Product;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//
//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
//import io.reactivex.rxjava3.annotations.NonNull;
//import io.reactivex.rxjava3.core.Observable;
//import io.reactivex.rxjava3.core.Observer;
//import io.reactivex.rxjava3.disposables.Disposable;
//import io.reactivex.rxjava3.schedulers.Schedulers;
//
//public class CementActivity extends AppCompatActivity {
//
//    private Adapter mAdapter;
//
//    private ArrayList<String> productsImageString=new ArrayList<>();
//
//
//    private RecyclerView mNumbersList;
//
//    private URL weatherRequestUrl;
//
//    ArrayList<Product> products=new ArrayList<>();
//
//    static Bitmap noImageBitmap ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cement);
//
//        mNumbersList = findViewById(R.id.rv_numbers);
//
//        noImageBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.noimage2);
//
//        Observable<String> obString=  Observable.fromCallable(() -> {
//
//            return getResponse();
//        });
//
//
//        obString.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
//
//                (String st)->{
//                    System.out.println(st);
//                    products= JsonUtils.getDetailsFromJson(st, "BudivelniSumishi");
//                    productsImageString=JsonUtils.getImageStringFromJson(st, "BudivelniSumishi");
//                    mAdapter = new Adapter(CementActivity.this, products);
//                    mNumbersList.setAdapter(mAdapter);
//
//
//                    final int[] ii = {0};
//
////
//
//                    Observable<Bitmap>bn=Observable.create(s->{
//
//                        for(String g : productsImageString)
//
//
//                            s.onNext(getBitmap("https://budmagas.herokuapp.com/get-image?image=" + g));
//
//
//                    });
//
//
//                    bn.subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Observer<Bitmap>() {
//                                           @Override
//                                           public void onSubscribe(@NonNull Disposable d) {
//
//                                           }
//
//                                           @Override
//                                           public void onNext(@NonNull Bitmap bitmap) {
//
//                                               products.get(ii[0]).setImageBitmap(bitmap);
//                                               mAdapter.notifyDataSetChanged();
//                                               ii[0]++;
//
//                                           }
//
//                                           @Override
//                                           public void onError(@NonNull Throwable e) {
//
//                                               e.printStackTrace();
//
//                                           }
//
//                                           @Override
//                                           public void onComplete() {
//
//
//
//                                           }
//
//
//                                       }
//
//
//                            );
//
//
//                });
//
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(CementActivity.this);
//        mNumbersList.setLayoutManager(layoutManager);
//        mAdapter = new Adapter(CementActivity.this, products);
//        mNumbersList.setAdapter(mAdapter);
//        mAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
//                                                 @Override
//                                                 public void onChanged() {
//                                                     super.onChanged();
//                                                 }
//                                             }
//        );
//
//    }
//
//
//    public String getResponse()
//    {
//        try {
//            weatherRequestUrl = new URL("https://budmagas.herokuapp.com/?category=budsumishi");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//        String jsonWeatherResponse = "";
//
//        try {
//            jsonWeatherResponse = NetworkUtils
//                    .getResponseFromHttpUrl(weatherRequestUrl); // json строка з сервера
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return jsonWeatherResponse;
//    }
//
//
//
//    public static Bitmap getBitmap(String url) throws IOException {
//        try {
//
//            InputStream is = (InputStream) new URL(url).getContent();
//
//
//
//            return BitmapFactory.decodeStream(is);
//        } catch (Exception e) {
//
//            return noImageBitmap;
//        }
//    }
//}
