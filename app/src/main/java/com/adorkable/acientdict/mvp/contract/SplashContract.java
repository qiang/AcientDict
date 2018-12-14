package com.adorkable.acientdict.mvp.contract;

import android.view.animation.Animation;

import com.adorkable.acientdict.mvp.IView;

/**
 * Author: liuqiang
 * Date: 2018-12-13
 * Time: 19:40
 * Description:
 */
public class SplashContract {

    /**
     * Created by liuqiang
     * Date: 2016-04-05
     * Time: 19:03
     */
    public interface Presenter {
        void initialized();
    }

    /**
     * Author:  liuqiang
     * Date:    2016/3/9.
     * Description:
     */
    public interface View extends IView{

        void animateBackgroundImage(Animation animation);

        void initializeViews(String versionName, String copyright, int backgroundResId);

        void navigateToHomePage();
    }
}
