package com.najafi.ali.personalmanagement.Activities.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.najafi.ali.personalmanagement.Activities.Home.Home;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.Model.Jobs;
import com.najafi.ali.personalmanagement.Model.JobsAdapter;
import com.najafi.ali.personalmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class Activity extends MyActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    JobsAdapter adapter;
    List<Jobs> jobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        init();
        prepareData();
        setUpAdapter();


        floatHelpBtn();
    }

    private void init() {
        recyclerView = findViewById(R.id.listOfJobs);
        jobs = new ArrayList<>();
        adapter = new JobsAdapter(jobs, this,this);

    }

    private void setUpAdapter() {
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration divider = new
                DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(
                ContextCompat.getDrawable(getBaseContext(), R.drawable.divider)
        );
        recyclerView.addItemDecoration(divider);
    }

    private void prepareData() {
        if (jobs == null) jobs = new ArrayList<>();
        jobs.add(new Jobs(1, R.drawable.a, "PeakyBlinders123456787654321234567898", 500, 900, 1800));
        jobs.add(new Jobs(2, R.drawable.b, "The 400 Blows", 340, 100, 2000));
        jobs.add(new Jobs(3, R.drawable.c, "La Haine", 900, 200, 3000));
        jobs.add(new Jobs(4, R.drawable.d, "The Godfather", 700, 300, 4000));
        jobs.add(new Jobs(5, R.drawable.e, "Man Bites Dog", 800, 400, 5000));
        jobs.add(new Jobs(6, R.drawable.f, "The Departed", 179, 500, 6800));
        jobs.add(new Jobs(7, R.drawable.g, "Umberto D.", 890, 600, 7000));
        jobs.add(new Jobs(8, R.drawable.h, "White Heat", 777, 700, 9000));
        jobs.add(new Jobs(9, R.drawable.i, "All Quiet on the Western Front", 990, 800, 1000));
        jobs.add(new Jobs(10, R.drawable.j, "Duck Soup", 5000, 900, 3331));
        jobs.add(new Jobs(11, R.drawable.k, "Mafioso", 888, 950, 4455));
        jobs.add(new Jobs(12, R.drawable.l, "Stalag 17", 1000, 340, 6425));
        jobs.add(new Jobs(13, R.drawable.m, "The Shawshank Redemption", 222, 430, 2562));
        jobs.add(new Jobs(14, R.drawable.n, "The Dark Knight", 189, 440, 23525));
        jobs.add(new Jobs(15, R.drawable.o, " Fight Club", 689, 9100, 245225));
        jobs.add(new Jobs(16, R.drawable.o, " Fight Cldffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffub", 689, 9100, 245225));
    }

    private void floatHelpBtn() {
        AllAngleExpandableButton button = findViewById(R.id.button_expandable);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {
                R.drawable.add,
                R.drawable.sign_out,
                R.drawable.home,
                R.drawable.work,
                R.drawable.money};
        int[] colors = {
                Color.parseColor("#f1c40f"),
                Color.parseColor("#e74c3c"),
                Color.parseColor("#2ecc71"),
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
                    Intent i = new Intent(Activity.this, LoginActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 2) {
                    Intent i = new Intent(Activity.this, Home.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 3) {

                } else if (index == 4) {

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
