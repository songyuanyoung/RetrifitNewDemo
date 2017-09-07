package com.example.zach.retrifitnewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://rjtmobile.com/ansari/shopingcart/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build();
        RetrofitService2 service = retrofit.create(RetrofitService2.class);
        Call<com.example.zach.retrifitnewdemo.Response> call = service.getData(107);

        call.enqueue(new Callback<com.example.zach.retrifitnewdemo.Response>() {
            @Override
            public void onResponse(Call<com.example.zach.retrifitnewdemo.Response> call, Response<com.example.zach.retrifitnewdemo.Response> response) {
                textView.setText(response.body().getSubCategory().toString());
            }

            @Override
            public void onFailure(Call<com.example.zach.retrifitnewdemo.Response> call, Throwable t) {

            }
        });




    }
}
