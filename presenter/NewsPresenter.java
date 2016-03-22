package com.chs.myrxjava.presenter;

import android.util.Log;

import com.chs.myrxjava.model.NewListModel;
import com.chs.myrxjava.model.bean.DouBean;
import com.chs.myrxjava.model.bean.PicBean;
import com.chs.myrxjava.view.viewinterface.INewView;

import rx.Subscriber;

/**
 * 作者：chs on 2016/3/15 14:35
 * 邮箱：657083984@qq.com
 */
public class NewsPresenter {
    private NewListModel newListModel = new NewListModel();
    private INewView iNewView;

    public NewsPresenter(INewView iNewView) {
        this.iNewView = iNewView;
    }
    public void loadData(){
        newListModel.getNewsList(new Subscriber<DouBean>() {
            @Override
            public void onCompleted() {
                Log.e("NewsPresenter","onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("NewsPresenter","onError");
            }

            @Override
            public void onNext(DouBean picBean) {
                Log.e("NewsPresenter","onNext");
                iNewView.showInfos(picBean);
                if(picBean==null){
                    iNewView.noInfos();
                }
            }
        });
    }
    public void loadPic(){
        newListModel.getPicList(new Subscriber<PicBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PicBean picBean) {
                Log.e("NewsPresenter","onNext");
            }
        });
    }
}
