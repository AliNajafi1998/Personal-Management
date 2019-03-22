package com.najafi.ali.personalmanagement.Activities.LoginPage;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.StatusBar;

public class LoginActivity extends MyActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBar.initStatusBar(this);
        setContentView(R.layout.activity_login);
        View v = findViewById(R.id.bg_login);

        AnimationDrawable animationDrawable = (AnimationDrawable) v.getBackground();

        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);

        animationDrawable.start();
    }



}
