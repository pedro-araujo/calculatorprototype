package com.colorlesscube.calculatorprototype;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by pedro on 6/10/15.
 */
public class prototypeEditText extends EditText {

    public prototypeEditText(Context context) {
        this(context, null);
    }

    public prototypeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public prototypeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_UP) {
            // Hack to prevent keyboard and insertion handle from showing.
            cancelLongPress();
        }
        return super.onTouchEvent(event);
    }
}