package com.najafi.ali.personalmanagement.Activities.Home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fangxu.allangleexpandablebutton.AllAngleExpandableButton;
import com.fangxu.allangleexpandablebutton.ButtonData;
import com.fangxu.allangleexpandablebutton.ButtonEventListener;
import com.najafi.ali.personalmanagement.Activities.Activity.Activity;
import com.najafi.ali.personalmanagement.Activities.LoginPage.LoginActivity;
import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.TypeFace;
import com.najafi.ali.personalmanagement.fragments.home.HomeFragment1;
import com.najafi.ali.personalmanagement.fragments.home.HomeFragment2;
import com.najafi.ali.personalmanagement.fragments.home.HomeFragment3;

import java.util.ArrayList;
import java.util.List;

public class Home extends MyActivity {
    ArrayList<Fragment> homeFragments = new ArrayList<>();
    ArrayList<String> homeTabItems = new ArrayList<>();

    TabLayout tabLayout;
    ViewPager viewPager;
    SlidePagerAdapter slidePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        preparingData();
        setUpViewPager();

        changeTabsFont();
        floatHelpBtn();

    }

    private void changeTabsFont() {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(TypeFace.createTypeFaceIransansmobile(getApplicationContext()));
                }
            }
        }
    }

    private void setUpViewPager() {
        viewPager.setAdapter(slidePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void init() {
        tabLayout = findViewById(R.id.tabLayoutHome);
        viewPager = findViewById(R.id.view_pager_home);
        slidePagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
    }

    private void floatHelpBtn() {
        AllAngleExpandableButton button = findViewById(R.id.button_expandable);
        final List<ButtonData> buttonDatas = new ArrayList<>();
        int[] drawable = {
                R.drawable.add,
                R.drawable.sign_out,
                R.drawable.activity,
                R.drawable.work,
                R.drawable.money};
        int[] colors = {
                Color.parseColor("#f1c40f"),
                Color.parseColor("#e74c3c"),
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

                    Intent i = new Intent(Home.this, Activity.class);
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

    private void preparingData() {
        homeTabItems.add("گزارش عملکرد");
        homeTabItems.add("گزارش فعالیت ها");
        homeTabItems.add("گزارش پرداخت ها");
        homeFragments.add(new HomeFragment3());
        homeFragments.add(new HomeFragment1());//Here The fragments must be added!
        homeFragments.add(new HomeFragment2());
    }

    class SlidePagerAdapter extends FragmentPagerAdapter {
        SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return homeFragments.get(i);
        }

        @Override
        public int getCount() {
            return homeFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return homeTabItems.get(position);
        }

    }
}
