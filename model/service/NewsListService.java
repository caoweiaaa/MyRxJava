package com.chs.myrxjava.model.service;

import com.chs.myrxjava.model.bean.DouBean;
import com.chs.myrxjava.model.bean.PicBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：chs on 2016/3/15 12:14
 * 邮箱：657083984@qq.com
 */
public interface NewsListService {
//    @GET("list.json")
//    public Observable<PicBean> getNews(@Query("channel") String type);
    @GET("top250")
    Observable<DouBean> getNews(@Query("start") int start,@Query("count") int count);

    @GET("list.json")
    Observable<PicBean> getPic(@Query("channel") String type);
}
