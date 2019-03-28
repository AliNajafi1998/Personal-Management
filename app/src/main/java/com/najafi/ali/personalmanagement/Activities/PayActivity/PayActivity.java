package com.najafi.ali.personalmanagement.Activities.PayActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.najafi.ali.personalmanagement.Activities.Activity.Activity;
import com.najafi.ali.personalmanagement.Activities.Home.Home;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.Activities.Work.WorkActivity;
import com.najafi.ali.personalmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends MyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        floatHelpBtn();
    }

    private void floatHelpBtn() {
        AllAngleExpandableButton button = findViewById(R.id.button_expandable);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {
                R.drawable.add,
                R.drawable.sign_out,
                R.drawable.activity,
                R.drawable.home,
                R.drawable.work};
        int[] colors = {
                Color.parseColor("#f1c40f"),
                Color.parseColor("#e74c3c"),
                Color.parseColor("#3498db"),
                Color.parseColor("#2ecc71"),
                Color.parseColor("#FD007B")
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
                    Intent i = new Intent(PayActivity.this, LoginActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 2) {
                    Intent i = new Intent(PayActivity.this, Activity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 3) {
                    Intent i = new Intent(PayActivity.this, Home.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 4) {
                    Intent i = new Intent(PayActivity.this, WorkActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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

    public void addPay(View view) {
    }
}
