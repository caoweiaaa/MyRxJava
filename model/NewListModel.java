package com.chs.myrxjava.model;

import com.chs.myrxjava.Url;
import com.chs.myrxjava.model.bean.PicBean;
import com.chs.myrxjava.model.service.NewsListService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：chs on 2016/3/15 13:42
 * 邮箱：657083984@qq.com
 */
public class NewListModel {
    //"http://api.sina.cn/sinago/list.json?channel=hdpic_toutiao&adid=4ad30dabe134695c3b7c3a65977d7e72&wm=b207&from=6042095012
    // &chwm=12050_0001&oldchwm=&imei=867064013906290&uid=802909da86d9f5fc&p=&chwm=12050_0001&oldchwm=&imei=867064013906290&uid=802909da86d9f5fc&p=1";
    public static String BaseUrl = "http://api.sina.cn/sinago/";
    public static String YULE  = Url.CommonUrl + "T1348649079062" + "/" + "0" + Url.endUrl;

    public void getNewsList(Subscriber<String> subscriber) {
        createService().getNews("hdpic_toutiao&adid=4ad30dabe134695c3b7c3a65977d7e72&wm=b207&from=6042095012&chwm=12050_0001&oldchwm=&imei=867064013906290&uid=802909da86d9f5fc&p=&chwm=12050_0001&oldchwm=&imei=867064013906290&uid=802909da86d9f5fc&p=1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
    private NewsListService createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(NewsListService.class);
    }
}
