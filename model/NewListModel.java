package com.chs.myrxjava.model;

import com.chs.myrxjava.Url;
import com.chs.myrxjava.model.bean.NewsBean;
import com.chs.myrxjava.model.service.NewsListService;

import java.util.List;

import retrofit2.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：chs on 2016/3/15 13:42
 * 邮箱：657083984@qq.com
 */
public class NewListModel {
    public static String YULE  = Url.CommonUrl + "T1348649079062" + "/" + "0" + Url.endUrl;

    public void getNewsList(Subscriber<NewsBean> subscriber) {
        createService().getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    private NewsListService createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YULE)
                .build();
        return retrofit.create(NewsListService.class);
    }
}
