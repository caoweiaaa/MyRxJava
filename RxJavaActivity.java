package com.chs.myrxjava;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 作者：chs on 2016/3/22 19:06
 * 邮箱：657083984@qq.com
 */
public class RxJavaActivity extends AppCompatActivity {
    private Subscriber<String> subscriber;
    private Action1<String> action1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);

        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onNext(String s) {
                Toast.makeText(RxJavaActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        action1 = new Action1<String>() {
            @Override
            public void call(String s) {
                Toast.makeText(RxJavaActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        initEvent();
        RxJavaFragment rxJavaFragment = new RxJavaFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.beginTransaction().add(R.id.fl_content,rxJavaFragment,"rxJavaFragment").commit();
    }

    private void initEvent() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("hello world");
                        subscriber.onCompleted();
                    }
                });
                observable.subscribe(action1);
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable<String> observable = Observable.just("hello")
                        .map(new Func1<String, String>() {
                            @Override
                            public String call(String s) {
                                return s + "你好";
                            }
                        });
                observable.subscribe(action1);
            }
        });
    }
}
