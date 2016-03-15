package com.chs.myrxjava.presenter;

import com.chs.myrxjava.model.NewListModel;
import com.chs.myrxjava.model.bean.NewsBean;
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
        newListModel.getNewsList(new Subscriber<NewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsBean newsBean) {
                iNewView.showInfos(newsBean);
                if(newsBean==null){
                    iNewView.noInfos();
                }
            }
        });
    }
}
