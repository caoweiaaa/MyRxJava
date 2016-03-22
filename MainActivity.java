package com.chs.myrxjava;

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
    private Subscriber<String> subscriber;
    private Action1<String> action1;
    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsPresenter = new NewsPresenter(this);
        newsPresenter.loadData();
        tv = (TextView) findViewById(R.id.tv);
        iv = (ImageView) findViewById(R.id.iv);
        initEvent();
//        subscriber = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
//            }
//        };
        action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        };

    }

    private void initEvent() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        subscriber.onNext("hello world");
//                        subscriber.onCompleted();
//                    }
//                });
                Observable<String> observable = Observable.just("hello")
                        .map(new Func1<String, String>() {
                            @Override
                            public String call(String s) {
                                return s+"你好";
                            }
                        });
                observable.subscribe(action1);
            }
        });

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsPresenter.loadPic();
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
