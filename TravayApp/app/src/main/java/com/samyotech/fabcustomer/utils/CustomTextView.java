package com.samyotech.fabcustomer.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by VARUN on 01/01/19.
 */
public class CustomTextView extends android.support.v7.widget.AppCompatTextView
{

    public CustomTextView(Context context) {

        super(context);
        applyCustomFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

//    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//        applyCustomFont(context);
//    }
    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Nunito-Light.ttf", context);
        setTypeface(customFont);
    }
}
