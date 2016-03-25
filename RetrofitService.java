package com.chs.myrxjava;

import com.chs.myrxjava.model.bean.DouBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：chs on 2016/3/23 10:11
 * 邮箱：657083984@qq.com
 */
public interface RetrofitService {
    @GET("top250")
    Call<DouBean> getData(@Query("start") int start,@Query("count") int count);
}
