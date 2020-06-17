package com.example.rxpractise;

import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.example.rxpractise.bean.Books;
import com.example.rxpractise.event.EventResponse;
import com.example.rxpractise.response.ResponeData;
import com.example.rxpractise.response.ResponseBookDownInfo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParctiseRXInte {

    Map<String, String> headers = new HashMap<>();
    //获取数据请求接口
    APIOnyx api = getServiceRequest();
    Books books = new Books();
    long bookid = 22780;
    public void createRequest() {

        //创建请求实体Body

        books.setBooks(new long[]{bookid});

        //添加请求头
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzU4NDUsImlhdCI6MTU5MjIwNjE3NCwiZXhwIjoxNTk0Nzk4MTc0fQ.IuG62sR7mjV2JMXaYl5NAGH0qLZjnR6bSHp0Fx2qcxI");
        headers.put("Content-Type", "application/json");


    }

    public void buybook() {
        Call<String> call = api.buybooks(headers, bookid, books);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response != null && response.body() != null) {

                    EventManager.getInstance().getEvent().post(new EventResponse(response.body()));
                    Log.e("zhu", response.body());
                    Log.e("zhu", "Request Header: Authorization:" + response.raw().request().header("Authorization"));
                }else{
                    try {
                        EventManager.getInstance().getEvent().post(new EventResponse(response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("zhu", t.getMessage());
            }
        });
    }

    Gson gson = new Gson();
    public void downinfo() {
        Call<ResponeData<ResponseBookDownInfo>> calldown = api.getDownBookInfo(headers, bookid);

        calldown.enqueue(new Callback<ResponeData<ResponseBookDownInfo>>() {
            @Override
            public void onResponse(Call<ResponeData<ResponseBookDownInfo>> call, Response<ResponeData<ResponseBookDownInfo>> response) {
                if(response != null){
                    String json = gson.toJson(response.body().data);
//                    Log.e("zhu", json);
                    EventManager.getInstance().getEvent().post(new EventResponse(json));
                    LogUtils.json(json);
                }
            }

            @Override
            public void onFailure(Call<ResponeData<ResponseBookDownInfo>> call, Throwable t) {

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
