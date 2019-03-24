package com.najafi.ali.personalmanagement.Activities.Home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.LoginPage.SignUpActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends MyActivity {
    private float dX;
    private float dY;
    private float lastAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AllAngleExpandableButton button = (AllAngleExpandableButton) findViewById(R.id.button_expandable);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {
                R.drawable.add,
                R.drawable.sign_out,
                R.drawable.home,
                R.drawable.activity,
                R.drawable.work,
                R.drawable.money};
        int[] colors = {
                Color.parseColor("#f1c40f"),
                Color.parseColor("#e74c3c"),
                Color.parseColor("#2ecc71"),
                Color.parseColor("#3498db"),
                Color.parseColor("#FD007B"),
                Color.parseColor("#9b59b6")
        };
        for (int i = 0; i < drawable.length; i++) {
            ButtonData buttonData = ButtonData.buildIconButton(this, drawable[i], 10);
            buttonData.setBackgroundColor(colors[i]);
            buttonDatas.add(buttonData);
        }
        button.setButtonDatas(buttonDatas);

        button.setButtonEventListener(new ButtonEventListener() {
            @Override
            public void onButtonClicked(int index) {
                //do whatever you want,the param index is counted from startAngle to endAngle,
                //the value is from 1 to buttonCount - 1(buttonCount if aebIsSelectionMode=true)
                if (index == 1) {
                    Intent i = new Intent(Home.this, LoginActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 2) {

                } else if (index == 3) {

                } else if (index == 4) {

                } else if (index == 5) {

                }

            }

            @Override
            public void onExpand() {

            }

            @Override
            public void onCollapse() {

            }


        });

    }


}
