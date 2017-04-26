package com.myapplication;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WaterMark.USER_DETAILS= new String[]{"saurav", "sharma","18/10/1993","Dehradun","India","248001","26.00","28.00"};
    }

}


