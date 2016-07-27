package com.curry.stephen.androidanimatortest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by LingChong on 2016/7/27 0027.
 */
public class MyView extends View {

    private Point mPointCurrent;
    private Paint mPaint;
    private String mColor;

    private static final int RADIUS = 50;
    private static final String TAG = MyView.class.getSimpleName();

    public MyView(Context context) {
        super(context);
        initializePaint();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializePaint();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializePaint();
    }

    private void initializePaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
        mPaint.setColor(Color.parseColor(mColor));
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPointCurrent == null) {
            mPointCurrent = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimator();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        Log.i(TAG, String.format("X: %f, Y: %f:", mPointCurrent.getX(), mPointCurrent.getY()));
        canvas.drawCircle(mPointCurrent.getX(), mPointCurrent.getY(), RADIUS, mPaint);
    }

    private void startAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), new Point(RADIUS, RADIUS),
                new Point(getWidth() - RADIUS, getHeight() - RADIUS));
        Log.i(TAG, String.format("Width: %d, Height: %d", getWidth(), getHeight()));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPointCurrent = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
//        valueAnimator.setDuration(5000);
//        valueAnimator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#80ff0000", "#ff000000");

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimator).with(objectAnimator);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }
}
