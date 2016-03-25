package com.chs.myrxjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chs.myrxjava.model.bean.DouBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：chs on 2016/3/22 19:06
 * 邮箱：657083984@qq.com
 */
public class RetrofitActivity extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        textView = (TextView) findViewById(R.id.button1);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.douban.com/v2/movie/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                RetrofitService retrofitService = retrofit.create(RetrofitService.class);

                Call<DouBean> douBeanCall = retrofitService.getData(0,10);
                douBeanCall.enqueue(new Callback<DouBean>() {
                    @Override
                    public void onResponse(Call<DouBean> call, Response<DouBean> response) {
                        textView.setText(response.body().getTitle());
                    }

                    @Override
                    public void onFailure(Call<DouBean> call, Throwable t) {

                    }
                });
            }
        });
    }
}
