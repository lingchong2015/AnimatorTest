package com.curry.stephen.androidanimatortest;

import android.animation.TypeEvaluator;

/**
 * Created by LingChong on 2016/7/27 0027.
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point pointStart = (Point) startValue;
        Point pointEnd = (Point) endValue;
        return new Point(pointStart.getX() + fraction * (pointEnd.getX() - pointStart.getX()),
                pointStart.getY() + fraction * (pointEnd.getY() - pointStart.getY()));
    }
}
