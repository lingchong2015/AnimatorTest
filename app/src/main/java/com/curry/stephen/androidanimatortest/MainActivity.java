package com.curry.stephen.androidanimatortest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        findViewById(R.id.button_click).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                objectAnimatorTest();
//                objectAnimatorInXMLTest();
//            }
//        });

//        valueAnimatorTest();
    }

    private void valueAnimatorTest() {
        ValueAnimator valueAnimatorFloat = ValueAnimator.ofFloat(0f, 1f).setDuration(getResources().getInteger(
                android.R.integer.config_shortAnimTime));
        valueAnimatorFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.i(TAG, String.format("Current value of float is: %f", (float) animation.getAnimatedValue()));
            }
        });

        valueAnimatorFloat.setRepeatCount(1);
        valueAnimatorFloat.setRepeatMode(ValueAnimator.REVERSE);

        valueAnimatorFloat.start();

//        ValueAnimator valueAnimatorInt = ValueAnimator.ofInt(0, 1, 5).setDuration(getResources().getInteger(
//                android.R.integer.config_shortAnimTime));
//        valueAnimatorInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                Log.i(TAG, String.format("Current value of int is: %d", (int) animation.getAnimatedValue()));
//            }
//        });
//        valueAnimatorInt.start();
    }

    private void objectAnimatorTest() {
//        TextView textViewHelloWorld = (TextView) findViewById(R.id.text_view_hello_world);
//        ObjectAnimator objectAnimatorAlpha = ObjectAnimator.ofFloat(textViewHelloWorld, "alpha", 1f, 0f, 1f)
//                .setDuration(getResources().getInteger(android.R.integer.config_longAnimTime));
//        ObjectAnimator objectAnimatorMoveIn = ObjectAnimator.ofFloat(textViewHelloWorld, "translationX",
//                -50f, Float.valueOf(textViewHelloWorld.getTranslationX()));
//        ObjectAnimator objectAnimatorRotate = ObjectAnimator.ofFloat(textViewHelloWorld, "rotation", 0f, 360f);
//        ObjectAnimator objectAnimatorScaleY = ObjectAnimator.ofFloat(textViewHelloWorld, "scaleY", 1f, 3f, 1f);

//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(objectAnimatorAlpha).with(objectAnimatorScaleY).after(objectAnimatorMoveIn).before(objectAnimatorRotate);
//        animatorSet.setDuration(1000);
//        animatorSet.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                super.onAnimationStart(animation);
//                Log.i(TAG, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE).format(
//                        Calendar.getInstance().getTime()));
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//                Log.i(TAG, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE).format(
//                        Calendar.getInstance().getTime()));
//            }
//        });
//        animatorSet.start();
    }

    private void objectAnimatorInXMLTest() {
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.animator_text_view_hello_world);
//        animator.setTarget(findViewById(R.id.text_view_hello_world));
//        animator.start();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
