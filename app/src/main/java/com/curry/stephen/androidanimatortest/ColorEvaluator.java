package com.curry.stephen.androidanimatortest;

import android.animation.TypeEvaluator;

/**
 * Created by LingChong on 2016/7/27 0027.
 */
public class ColorEvaluator implements TypeEvaluator {

    /**
     * 计算从startValue到endValue过渡过程中百分比为fraction产生的颜色值.
     * @param fraction 百分比.
     * @param startValue 起始颜色,格式为#XXXXXXXX.
     * @param endValue 结束颜色,格式为#XXXXXXXX.
     * @return 返回格式为#XXXXXXXX的颜色值.
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        String startColorString = (String) startValue;
        String endColorString = (String) endValue;
        int startAlphaColor = Integer.parseInt(startColorString.substring(1, 3), 16);
        int startRedColor = Integer.parseInt(startColorString.substring(3, 5), 16);
        int startGreenColor = Integer.parseInt(startColorString.substring(5, 7), 16);
        int startBlueColor = Integer.parseInt(startColorString.substring(7, 9), 16);
        int endAlphaColor = Integer.parseInt(endColorString.substring(1, 3), 16);
        int endRedColor = Integer.parseInt(endColorString.substring(3, 5), 16);
        int endGreenColor = Integer.parseInt(endColorString.substring(5, 7), 16);
        int endBlueColor = Integer.parseInt(endColorString.substring(7, 9), 16);

        int alphColorDifference = Math.abs(startAlphaColor - endAlphaColor);
        int redColorDifference = Math.abs(startRedColor - endRedColor);
        int greenColorDifference = Math.abs(startGreenColor - endGreenColor);
        int blueColorDifference = Math.abs(startBlueColor - endBlueColor);

        int colorAlpha = getColor(alphColorDifference, fraction, startAlphaColor, endAlphaColor);
        int colorRed = getColor(redColorDifference, fraction, startRedColor, endRedColor);
        int colorGreen = getColor(greenColorDifference, fraction, startGreenColor, endGreenColor);
        int colorBlue = getColor(blueColorDifference, fraction, startBlueColor, endBlueColor);

        return "#" + getHexString(colorAlpha) + getHexString(colorRed) + getHexString(colorGreen) + getHexString(colorBlue);
    }

    private int getColor(int difference, float fraction, int startColor, int endColor) {
        int color;
        if (startColor >= endColor) {
            color = (int) (startColor - fraction * difference);
            if (color < endColor) {
                color = endColor;
            }
        } else {
            color = (int) (startColor + fraction * difference);
            if (color > endColor) {
                color = endColor;
            }
        }
        return color;
    }

    private String getHexString(int value) {
        String hexString = Integer.toHexString(value);
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString;
    }
}
