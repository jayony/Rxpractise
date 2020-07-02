package com.example.rxpractise;

import com.example.rxpractise.bean.Books;
import com.example.rxpractise.bean.CarBooks;
import com.example.rxpractise.response.ResponseClearCar;
import com.example.rxpractise.response.ResponseMyCar;
import com.example.rxpractise.response.ResponeData;
import com.example.rxpractise.response.ResponseBookDownInfo;
import com.example.rxpractise.response.ResponseOnderStatus;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIOnyx {

    String HEADER_AUTHORIZATION = "Authorization";

    @POST("api/1/shop/books/{bookid}/pay")
    Call<String> buybooks(@Header(HEADER_AUTHORIZATION) String headers, @Path("bookid") long bookid, @Body Books booksbean);

    @GET("api/1/shop/books/{bookid}/download/")
    Call<ResponeData<ResponseBookDownInfo>> getDownBookInfo(@Header(HEADER_AUTHORIZATION) String headers, @Path("bookid") long bookid  );

    @POST("api/1/carts/add")
    Call<ResponeData> addToCar(@HeaderMap Map<String,String> headers, @Body CarBooks booksbean);

    @GET("api/1/carts/me")
    Call<ResponseMyCar> getCar(@HeaderMap Map<String,String> headers);

    @DELETE("api/1/carts/clear")
    Call<ResponseClearCar> getClearCar(@HeaderMap Map<String,String> headers);

    @POST("/api/1/carts/remove")
    Call<ResponeData> removeBookFromCar(@HeaderMap Map<String,String> headers, @Body CarBooks booksbean);

    @GET("/api/1/orders/check")
    Call<ResponeData<ResponseOnderStatus>> getOrderStatus(@Query("out_trade_no") String order);

}
