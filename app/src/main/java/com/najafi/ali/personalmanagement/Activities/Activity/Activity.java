package com.najafi.ali.personalmanagement.Activities.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.najafi.ali.personalmanagement.Activities.Home.Home;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.Activities.PayActivity.PayActivity;
import com.najafi.ali.personalmanagement.Activities.Work.WorkActivity;
import com.najafi.ali.personalmanagement.ModelForJobs.Jobs;
import com.najafi.ali.personalmanagement.ModelForJobs.JobsAdapter;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.fragments.add.AddDialogFragment;
import com.najafi.ali.personalmanagement.fragments.delete.DeleteDialogFragment;


import java.util.ArrayList;
import java.util.List;

public class Activity extends MyActivity implements DeleteDialogFragment.Idelete, AddDialogFragment.AddItemInterface {

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
        adapter = new JobsAdapter(jobs, this, this);

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
        jobs.add(new Jobs(1, R.drawable.a, "PeakyBlinders123456787654321234567898", 500, 900, 1800, false));
        jobs.add(new Jobs(2, R.drawable.b, "The 400 Blows", 340, 100, 2000, false));
        jobs.add(new Jobs(3, R.drawable.c, "La Haine", 900, 200, 3000, false));
        jobs.add(new Jobs(4, R.drawable.d, "The Godfather", 700, 300, 4000, false));
        jobs.add(new Jobs(5, R.drawable.e, "Man Bites Dog", 800, 400, 5000, false));
        jobs.add(new Jobs(6, R.drawable.f, "The Departed", 179, 500, 6800, false));
        jobs.add(new Jobs(7, R.drawable.g, "Umberto D.", 890, 600, 7000, false));
        jobs.add(new Jobs(8, R.drawable.h, "White Heat", 777, 700, 9000, false));
        jobs.add(new Jobs(9, R.drawable.i, "All Quiet on the Western Front", 990, 800, 1000, true));
        jobs.add(new Jobs(10, R.drawable.j, "Duck Soup", 5000, 900, 3331, false));
        jobs.add(new Jobs(11, R.drawable.k, "Mafioso", 888, 950, 4455, false));
        jobs.add(new Jobs(12, R.drawable.l, "Stalag 17", 1000, 340, 6425, true));
        jobs.add(new Jobs(13, R.drawable.m, "The Shawshank Redemption", 222, 430, 2562, false));
        jobs.add(new Jobs(14, R.drawable.n, "The Dark Knight", 189, 440, 23525, false));
        jobs.add(new Jobs(15, R.drawable.o, " Fight Club", 689, 9100, 245225, false));
        jobs.add(new Jobs(16, R.drawable.o, " Fight Cldffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffub",
                689, 9100, 245225, false));
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
                    Intent i = new Intent(Activity.this, WorkActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 4) {
                    Intent i = new Intent(Activity.this, PayActivity.class);
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

    @Override
    public void deleted() {
        adapter.removeAt();
    }

    public void addActivity(View view) {
        AddDialogFragment fragment = new AddDialogFragment();
        fragment.show(getSupportFragmentManager(), "add");
    }

    @Override
    public void add(String duration, String paid, String name, String note) {
        adapter.addItem(duration, paid, name, name, R.drawable.c);
    }

    public void payOffTime(View view) {
        final Dialog dialog = new Dialog(this);
        final Dialog dialogConfirm = new Dialog(this);
        dialogConfirm.setContentView(R.layout.custom_dialog_2);
        dialogConfirm.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(R.layout.custom_dialog_1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        dialogConfirm.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                dialogConfirm.show();
                dialogConfirm.findViewById(R.id.btn_pay_2).setOnClickListener(new View.OnClickListener() {////////////
                    @Override
                    public void onClick(View v) {
                        dialogConfirm.dismiss();
                        //TODO
                    }
                });

                dialogConfirm.findViewById(R.id.btn_dismiss_2).setOnClickListener(new View.OnClickListener() {////////////
                    @Override
                    public void onClick(View v) {
                        dialogConfirm.dismiss();
                    }
                });
            }
        });
        dialog.findViewById(R.id.btn_dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void payOffMoney(View view) {
        final Dialog dialog = new Dialog(this);
        final Dialog dialogConfirm = new Dialog(this);
        dialogConfirm.setContentView(R.layout.custom_dialog_2);
        dialogConfirm.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(R.layout.custom_dialog_3);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        dialogConfirm.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.findViewById(R.id.btn_pay_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                dialogConfirm.show();
                dialogConfirm.findViewById(R.id.btn_pay_2).setOnClickListener(new View.OnClickListener() {////////////
                    @Override
                    public void onClick(View v) {
                        dialogConfirm.dismiss();
                        //TODO
                    }
                });

                dialogConfirm.findViewById(R.id.btn_dismiss_2).setOnClickListener(new View.OnClickListener() {////////////
                    @Override
                    public void onClick(View v) {
                        dialogConfirm.dismiss();
                    }
                });
            }
        });
        dialog.findViewById(R.id.btn_dismiss_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


}
