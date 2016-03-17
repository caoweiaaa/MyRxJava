package com.chs.myrxjava.model.service;

import com.chs.myrxjava.model.bean.PicBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 作者：chs on 2016/3/15 12:14
 * 邮箱：657083984@qq.com
 */
public interface NewsListService {
    @GET("list.json")
    public Observable<String> getNews(@Path("channel") String type);
}
