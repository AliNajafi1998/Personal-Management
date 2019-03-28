package com.najafi.ali.personalmanagement.Activities.Work;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.najafi.ali.personalmanagement.Activities.Activity.Activity;
import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;

import com.najafi.ali.personalmanagement.Activities.Home.Home;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.Activities.PayActivity.PayActivity;
import com.najafi.ali.personalmanagement.ModelForWork.Work;
import com.najafi.ali.personalmanagement.ModelForWork.WorkAdapter;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.fragments.add.AddDialogFragmentWork;
import com.najafi.ali.personalmanagement.fragments.delete.DeleteDialogFragmentWork;
import com.najafi.ali.personalmanagement.fragments.edit.EditDialogFragmentWork;

import java.util.ArrayList;
import java.util.List;

public class WorkActivity extends MyActivity implements DeleteDialogFragmentWork.Idelete,
        EditDialogFragmentWork.SaveChangeInterFace,
        AddDialogFragmentWork.AddItemInterface {

    private WorkAdapter workAdapter;
    private RecyclerView recyclerView;
    private List<Work> workList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        init();
        prepareData();
        setUpAdapter();
        floatHelpBtn();
    }

    private void prepareData() {
        if (workList == null) workList = new ArrayList<>();
        workList.add(new Work("The 400 Blows", R.drawable.a, true));
        workList.add(new Work("The Shawshank Redemption", R.drawable.b, false));
        workList.add(new Work("La Haine", R.drawable.c, true));
        workList.add(new Work("The Shawshank Redemption", R.drawable.d, false));
        workList.add(new Work("The 400 Blows", R.drawable.e, true));
        workList.add(new Work("La Haine", R.drawable.f, false));
        workList.add(new Work("All Quiet on the Western Front", R.drawable.g, true));
        workList.add(new Work("The 400 Blows", R.drawable.h, false));
        workList.add(new Work("Man Bites Dog", R.drawable.i, true));
        workList.add(new Work("The Shawshank Redemption", R.drawable.j, false));
        workList.add(new Work("The 400 Blows", R.drawable.k, true));
        workList.add(new Work("The Godfather", R.drawable.l, false));
        workList.add(new Work("The Departed", R.drawable.m, true));
        workList.add(new Work("Stalag 17", R.drawable.n, false));
        workList.add(new Work(" Fight Cldffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffub", R.drawable.o, true));
        workList.add(new Work("All Quiet on the Western Front", R.drawable.a, false));

    }

    private void init() {
        workList = new ArrayList<>();
        workAdapter = new WorkAdapter(this, workList, this);
        recyclerView = findViewById(R.id.listOfWork);

    }

    private void setUpAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(workAdapter);
        DividerItemDecoration divider = new
                DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(
                ContextCompat.getDrawable(getBaseContext(), R.drawable.divider)
        );
        recyclerView.addItemDecoration(divider);
    }

    private void floatHelpBtn() {
        AllAngleExpandableButton button = findViewById(R.id.button_expandable);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {
                R.drawable.add,
                R.drawable.sign_out,
                R.drawable.activity,
                R.drawable.home,
                R.drawable.money};
        int[] colors = {
                Color.parseColor("#f1c40f"),
                Color.parseColor("#e74c3c"),
                Color.parseColor("#3498db"),
                Color.parseColor("#2ecc71"),
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
                    Intent i = new Intent(WorkActivity.this, LoginActivity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 2) {
                    Intent i = new Intent(WorkActivity.this, Activity.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 3) {
                    Intent i = new Intent(WorkActivity.this, Home.class);
                    startActivity(i);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                } else if (index == 4) {
                    Intent i = new Intent(WorkActivity.this, PayActivity.class);
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
        workAdapter.removeAt();
    }

    @Override
    public void changeIt(String txtName) {
        workAdapter.editItem(txtName);
    }

    @Override
    public void add(String name) {
        workAdapter.addItem(name);
    }

    public void addWork(View view) {
        AddDialogFragmentWork fragment = new AddDialogFragmentWork();
        fragment.show(getSupportFragmentManager(), "addWork");
    }
}
