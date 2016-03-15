package com.chs.myrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chs.myrxjava.model.NewListModel;
import com.chs.myrxjava.model.bean.NewsBean;
import com.chs.myrxjava.presenter.NewsPresenter;
import com.chs.myrxjava.view.viewinterface.INewView;

public class MainActivity extends AppCompatActivity implements INewView{
    private NewsPresenter newsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsPresenter = new NewsPresenter(this);
        newsPresenter.loadData();
    }

    @Override
    public void showInfos(NewsBean newsBean) {

    }

    @Override
    public void noInfos() {

    }
}
