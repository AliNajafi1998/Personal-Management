package com.najafi.ali.personalmanagement.Activities.PayActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.najafi.ali.personalmanagement.Activities.Activity.Activity;
import com.najafi.ali.personalmanagement.Activities.Home.Home;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.Activities.Work.WorkActivity;
import com.najafi.ali.personalmanagement.ModelForPays.Pays;
import com.najafi.ali.personalmanagement.ModelForPays.PaysAdapter;
import com.najafi.ali.personalmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class PayActivity extends MyActivity {
    PaysAdapter paysAdapter;
    List<Pays> pays;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        init();
        prepareData();
        setUpAdapter();
        floatHelpBtn();
    }

    private void init() {
        pays = new ArrayList<>();
        paysAdapter = new PaysAdapter(this, pays);
        recyclerView = findViewById(R.id.listOfPays);
    }

    private void setUpAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(paysAdapter);

        DividerItemDecoration divider = new
                DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        divider.setDrawable(
                ContextCompat.getDrawable(getBaseContext(), R.drawable.divider)
        );
        recyclerView.addItemDecoration(divider);
    }

    private void prepareData() {
        if (pays == null) pays = new ArrayList<>();

        pays.add(new Pays(123.3, 123, "1399/3/2"));
        pays.add(new Pays(32, 123, "1389/3/2"));
        pays.add(new Pays(43, 44, "1379/3/2"));
        pays.add(new Pays(3, 123, "1396/3/2"));
        pays.add(new Pays(23, 123, "1359/3/2"));
        pays.add(new Pays(33, 44, "1349/3/2"));
        pays.add(new Pays(22, 123, "1339/3/2"));
        pays.add(new Pays(123.3, 123, "1329/3/2"));
        pays.add(new Pays(33, 34, "1394/3/2"));
        pays.add(new Pays(33, 123, "1393/3/2"));
        pays.add(new Pays(123.3, 34, "1392/3/2"));
        pays.add(new Pays(123.3, 123, "1399/3/2"));
        pays.add(new Pays(44, 123, "1399/3/2"));


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
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.add_pay_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.btn_dismiss_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.btn_add_new_pay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                paysAdapter.addItem(
                        ((TextInputEditText)dialog.findViewById(R.id.txt_cost_to_pay)).getText().toString(),
                        ((TextInputEditText)dialog.findViewById(R.id.txt_activity_duration)).getText().toString()
                );




            }
        });

    }
}
