package com.example.zach.retrifitnewdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhangwenpurdue on 9/5/2017.
 */

public interface RetrofitService2 {
    @GET("androidapp/cust_sub_category.php")
    Call<Response> getData(@Query("Id") int id);
}
