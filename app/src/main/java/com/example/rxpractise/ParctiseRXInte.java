package com.example.rxpractise;

import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.example.rxpractise.bean.Books;
import com.example.rxpractise.bean.CarBooks;
import com.example.rxpractise.event.EventPay;
import com.example.rxpractise.event.EventResponse;
import com.example.rxpractise.response.ResponseClearCar;
import com.example.rxpractise.response.ResponseMyCar;
import com.example.rxpractise.response.ResponeData;
import com.example.rxpractise.response.ResponseBookDownInfo;
import com.example.rxpractise.response.ResponseOnderStatus;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParctiseRXInte {

    //学武测试服务器Token
    String token1 = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzU4NDUsImlhdCI6MTU5MjIwNjE3NCwiZXhwIjoxNTk0Nzk4MTc0fQ.IuG62sR7mjV2JMXaYl5NAGH0qLZjnR6bSHp0Fx2qcxI";
    //小敏测试服务器Token
    String token2 = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NjQxODAsInd4VW5pb25pZCI6Im9JdWJZdm1kV0RLVEdTVlQ3SF8zVnoyVnIzcmsiLCJsb2dpblR5cGUiOiJ3ZWNoYXQiLCJpYXQiOjE1OTMzMjcyODQsImV4cCI6MTU5NTkxOTI4NH0.C_2_MaZrcqmRWoIWOlClCCCj1NLWI4wuEk-i8paV_W4";

    Map<String, String> headers = new HashMap<>();
    //获取数据请求接口
    APIOnyx api = getServiceRequest();
    Books books = new Books();

    CarBooks carBooks = new CarBooks();
    long bookid = 22638;

    public void createRequest() {

        //创建请求实体Body
        books.setBooks(new long[]{bookid});
        carBooks.setBookIds(new long[]{36, 37/*,38,39,55,88,98,132*/});
        headers.put("Authorization", token2);
    }

    public APIOnyx getServiceRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dev.send2boox.com/")
//                .baseUrl("http://192.168.11.27:7002/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(APIOnyx.class);
    }

    public void getClient() {
    }

    public void buybook() {
        Call<String> call = api.buybooks(token1, bookid, books);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response != null && response.body() != null) {

                    EventManager.getInstance().getEvent().post(new EventResponse(response.body()));
                    Log.e("zhu", response.body());
                    Log.e("zhu", "Request Header: Authorization:" + response.raw().request().header("Authorization"));
                } else {
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
        Call<ResponeData<ResponseBookDownInfo>> calldown = api.getDownBookInfo(token1, bookid);
        calldown.enqueue(new Callback<ResponeData<ResponseBookDownInfo>>() {
            @Override
            public void onResponse(Call<ResponeData<ResponseBookDownInfo>> call, Response<ResponeData<ResponseBookDownInfo>> response) {
                if (response != null) {
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


    public void addToCar() {
        Call<ResponeData> calldown = api.addToCar(headers, carBooks);

        calldown.enqueue(new Callback<ResponeData>() {
            @Override
            public void onResponse(Call<ResponeData> call, Response<ResponeData> response) {
                if (response != null) {
                    String json = gson.toJson(response.body().data);
                    LogUtils.json(json);

                    EventManager.getInstance().getEvent().post(new EventResponse(json));
                }
            }

            @Override
            public void onFailure(Call<ResponeData> call, Throwable t) {

            }
        });
    }

    public void getCar() {
        Call<ResponseMyCar> calldown = api.getCar(headers);

        calldown.enqueue(new Callback<ResponseMyCar>() {
            @Override
            public void onResponse(Call<ResponseMyCar> call, Response<ResponseMyCar> response) {
                if (response != null) {
                    String json = gson.toJson(response.body().data);
                    LogUtils.json(json);
                    EventManager.getInstance().getEvent().post(new EventResponse(json));
                }
            }

            @Override
            public void onFailure(Call<ResponseMyCar> call, Throwable t) {

            }
        });
    }

    //清空购物车
    public void clearCar() {

        Call<ResponseClearCar> calldown = api.getClearCar(headers);

        calldown.enqueue(new Callback<ResponseClearCar>() {
            @Override
            public void onResponse(Call<ResponseClearCar> call, Response<ResponseClearCar> response) {
                if (response != null) {
                    String json = gson.toJson(response.body().data);
                    LogUtils.json(json);
                    EventManager.getInstance().getEvent().post(new EventResponse(json));
                }
            }

            @Override
            public void onFailure(Call<ResponseClearCar> call, Throwable t) {

            }
        });

    }


    public void removeBook() {

        CarBooks cb = new CarBooks();
        cb.setBookIds(new long[]{36});
        Call<ResponeData> calldown = api.removeBookFromCar(headers, cb);

        calldown.enqueue(new Callback<ResponeData>() {
            @Override
            public void onResponse(Call<ResponeData> call, Response<ResponeData> response) {
                if (response != null) {
                    String json = gson.toJson(response.body().data);
                    LogUtils.json(json);

                    EventManager.getInstance().getEvent().post(new EventResponse(json));
                }
            }

            @Override
            public void onFailure(Call<ResponeData> call, Throwable t) {

                Log.e("", "");

            }
        });
    }


    public void getOrderStatus(String orderID) {

        Call<ResponeData<ResponseOnderStatus>> calldown = api.getOrderStatus(orderID);

        calldown.enqueue(new Callback<ResponeData<ResponseOnderStatus>>() {
            @Override
            public void onResponse(Call<ResponeData<ResponseOnderStatus>> call, Response<ResponeData<ResponseOnderStatus>> response) {
                if (response != null) {
                    String json = gson.toJson(response.body().data);
                    ResponseOnderStatus responseOnderStatus = response.body().data;
                    int status = responseOnderStatus.getStatus();
                    switch (status) {
                        case 0:
                            EventManager.getInstance().getEvent().post(new EventPay(EventPay.NOPAY));
                            break;
                        case 1:
                            EventManager.getInstance().getEvent().post(new EventPay(EventPay.SUCCESS));
                            break;
                    }
                    LogUtils.json(json);
                }
            }

            @Override
            public void onFailure(Call<ResponeData<ResponseOnderStatus>> call, Throwable t) {

                Log.e("", "");

            }
        });
    }

}
