package com.adorkable.acientdict.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by liuqiang
 * Date: 2015-12-30
 * Time: 15:21
 */
public class InterceptEventLinearLayout extends LinearLayout {
    public InterceptEventLinearLayout(Context context) {
        super(context);
    }

    public InterceptEventLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptEventLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
