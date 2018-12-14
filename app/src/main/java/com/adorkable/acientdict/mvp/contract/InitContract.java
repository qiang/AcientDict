package com.adorkable.acientdict.mvp.contract;

import com.adorkable.acientdict.entity.DictInitEntity;
import com.adorkable.acientdict.mvp.IView;

/**
 * Author: liuqiang
 * Date: 2018-12-13
 * Time: 19:36
 * Description:
 */
public interface InitContract {
    /**
     * Author:  liuqiang
     * Date:    2016/5/2.
     * Description:
     */
    interface View extends IView {

        void updateView(DictInitEntity dictInitEntity);
    }

    /**
     * Created by liuqiang
     * Date: 2016-05-02
     * Time: 20:51
     */
    interface Presenter {

        void loadData();
    }
}
