package com.bwf.lgqingdan.gui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bwf.lgqingdan.R;

/**
 * Created by LG on 2016/10/25.
 * Tips:旋转的TextView
 */

public class RotateTextView extends TextView{
    private int degress;
    public RotateTextView(Context context) {
        super(context);
    }

    public RotateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.RotateTextView);
        degress = array.getInteger(R.styleable.RotateTextView_degress,0);
        array.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.save();
        canvas.rotate(degress,getWidth()/2,getHeight()/2);
        super.onDraw(canvas);
        canvas.restore();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
