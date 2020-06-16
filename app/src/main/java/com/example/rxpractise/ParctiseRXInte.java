package com.example.rxpractise;

import android.util.Log;

import com.example.rxpractise.bean.Books;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParctiseRXInte {

    public void main() {
//
//        Observer observer = new Observer() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(Object o) {
//
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//
//
//
//        Observable.just("one", "two", "three", "four", "five")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);

        //获取数据请求接口
        APIOnyx api = getServiceRequest();


        //创建请求实体Body
        Books books = new Books();
        books.setBooks(new long[]{22780});

        //添加请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzU4NDUsImlhdCI6MTU5MjIwNjE3NCwiZXhwIjoxNTk0Nzk4MTc0fQ.IuG62sR7mjV2JMXaYl5NAGH0qLZjnR6bSHp0Fx2qcxI");
        headers.put("Content-Type", "application/json");
        Call<String> call = api.buybooks(headers, 22780, books);

//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//                if (response != null && response.body() != null) {
//                    Log.e("zhu", response.body());
//                    Log.e("zhu", "Request Header: Authorization:" + response.raw().request().header("Authorization"));
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.e("zhu", t.getMessage());
//            }
//        });


        Call<String> calldown = api.getDownBookInfo(headers, 22780);
        calldown.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response != null && response.body() != null) {
                    Log.e("zhu", response.body());
                    Log.e("zhu", "Request Header: Authorization:" + response.raw().request().header("Authorization"));
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("zhu", t.getMessage());
            }
        });
    }


    public APIOnyx getServiceRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev.send2boox.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(APIOnyx.class);
    }

}
