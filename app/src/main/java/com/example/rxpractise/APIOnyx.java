package com.example.rxpractise;

import com.example.rxpractise.bean.Books;
import com.example.rxpractise.response.ResponeData;
import com.example.rxpractise.response.ResponseBookDownInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIOnyx {

    @POST("api/1/shop/books/{bookid}/pay")
    Call<String> buybooks(@HeaderMap Map<String,String> headers, @Path("bookid") long bookid, @Body Books booksbean);


    @GET("api/1/shop/books/{bookid}/download/")
    Call<ResponeData<ResponseBookDownInfo>> getDownBookInfo(@HeaderMap Map<String,String> headers, @Path("bookid") long bookid  );
}
