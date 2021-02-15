package com.example.budivelnymagasin.Utils;

import android.graphics.Bitmap;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductApiRetrofit {

    @GET("?category=vsedlyaremontu")
    Observable<List<Product>> getProductsObservableVseDlyaRemontu();

    @GET("?category=electroinstrument")
    Observable<List<Product>> getProductsObservableElectroinstrument();

    @GET("?category=santehnica")
    Observable<List<Product>> getProductsObservableSantehnica();

    @GET("?category=sadgorod")
    Observable<List<Product>> getProductsObservableSadGorod();

    @GET("?category=instrumenty")
    Observable<List<Product>> getProductsObservableInstrumenty();

    @GET("?category=budsumishi")
    Observable<List<Product>> getProductsObservableBudSumishi();

    @GET("retrofittest")
    Call<List<Product>> getProducts();

    @GET("get-image")
    Call <Bitmap> getImage (@Query("image") String image);
}
