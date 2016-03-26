package com.chs.myrxjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chs.myrxjava.model.bean.DouBean;
import com.chs.myrxjava.presenter.NewsPresenter;
import com.chs.myrxjava.view.viewinterface.INewView;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends AppCompatActivity implements INewView{
    private NewsPresenter newsPresenter;
    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsPresenter = new NewsPresenter(this);
//        newsPresenter.loadData();
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        initEvent();
    }

    private void initEvent() {

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsPresenter.loadData();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RxJavaActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RetrofitActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showInfos(DouBean newsBean) {
        tv.setText(newsBean.getTitle());
        iv.setImageURI(Uri.parse(newsBean.getSubjects().get(0).getImages().getSmall()));
    }

    @Override
    public void noInfos() {

    }
}
