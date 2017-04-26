package com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by saurav on 7/4/17.
 */

public class WaterMark extends RelativeLayout {

    int DetailsIdx = 0;
    Context context;
    private TextView tv;
    public static String[] USER_DETAILS;

/*    public static String[] USER_DETAILS =
            {
                    "saurav", "sharma", "18/10/1993", "Dehradun", "India"
            };*/
    private View view;

    public WaterMark(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public WaterMark(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        view = LayoutInflater.from(context).inflate(R.layout.water_mark, this, true);
        tv = (TextView) view.findViewById(R.id.watermaker);
        Animation shake = AnimationUtils.loadAnimation(context, R.anim.sequential);
        tv.startAnimation(shake);
        delayHandle.post(textchange);

    }

    public int getSize() {
        return USER_DETAILS.length;
    }

    private final Handler delayHandle = new Handler();

    private final Runnable textchange = new Runnable() {

        public void run() {
            if (DetailsIdx < getSize() - 1) {
                DetailsIdx++;
            } else {
                DetailsIdx = 0;
            }
            changetheText(getWord(DetailsIdx));
            delayHandle.postDelayed(this, 10000);
        }

    };

    public void changetheText(String text) {
        tv.setText(text);
    }

    public String getWord(int idx) {
        return USER_DETAILS[idx];
    }

}
