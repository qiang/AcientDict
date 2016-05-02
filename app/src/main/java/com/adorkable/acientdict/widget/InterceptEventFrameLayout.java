package com.adorkable.acientdict.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by liuqiang
 * Date: 2015-12-30
 * Time: 15:26
 */
public class InterceptEventFrameLayout extends FrameLayout {

    public InterceptEventFrameLayout(Context context) {
        super(context);
    }

    public InterceptEventFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InterceptEventFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
