package com.chs.myrxjava.view.viewinterface;

import com.chs.myrxjava.model.bean.NewsBean;

import java.util.List;

/**
 * 作者：chs on 2016/3/15 14:41
 * 邮箱：657083984@qq.com
 */
public interface INewView {

    void showInfos(NewsBean newsBean);

    void noInfos();
}
