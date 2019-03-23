package com.najafi.ali.personalmanagement.Activities.LoginPage;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;

import com.najafi.ali.personalmanagement.Activities.MyActivity;
import com.najafi.ali.personalmanagement.R;
import com.najafi.ali.personalmanagement.Utils.StatusBar;

public class LoginActivity extends MyActivity {

    TextInputEditText txtInputPassword;
    TextInputEditText txtInputEmail;
    TextInputLayout textInputLayoutPassword;
    TextInputLayout textInputLayoutEmail;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBar.initStatusBar(this);
        setContentView(R.layout.activity_login);
        init();
        changeFont();

//        animation();
    }

    private void changeFont() {
        txtInputPassword.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "fonts/iransansmobile.ttf"));
        txtInputEmail.setTypeface(Typeface.createFromAsset(getResources().getAssets(), "fonts/iransansmobile.ttf"));
    }

    private void init() {
        textInputLayoutPassword = findViewById(R.id.passwordInput);
        textInputLayoutEmail = findViewById(R.id.emailInput);
        txtInputPassword = findViewById(R.id.pass);
        txtInputEmail = findViewById(R.id.enter);
    }

//    private void animation() {
//        View v = findViewById(R.id.bg_login);
//        AnimationDrawable animationDrawable = (AnimationDrawable) v.getBackground();
//        animationDrawable.setEnterFadeDuration(2500);
//        animationDrawable.setExitFadeDuration(5000);
//        animationDrawable.start();
//    }

    private boolean isEmailValid() {
        String emailText = textInputLayoutEmail.getEditText().getText().toString().trim();
        if (emailText.isEmpty()) {

            return false;
        } else {
            textInputLayoutEmail.setError(null);
            return true;
        }

    }

    private boolean isPasswordValid() {
        String passwordlText = textInputLayoutPassword.getEditText().getText().toString().trim();
        if (passwordlText.isEmpty()) {

            return false;
        } else {
//            textInputLayoutPassword.setError(null);
            return true;
        }
    }

    public void confirm(View v) {
        if (v.getId() == R.id.btn_login) {
            if (!isEmailValid()) {
                textInputLayoutEmail.setError("این قسمت بایدپرشود");
                textInputLayoutEmail.setErrorEnabled(true);
            } else {
                textInputLayoutEmail.setErrorEnabled(false);
            }

            if (!isPasswordValid()) {
                textInputLayoutPassword.setError("این قسمت بایدپرشود");
                textInputLayoutPassword.setErrorEnabled(true);
            } else {
                textInputLayoutPassword.setErrorEnabled(false);
            }

        } else if (v.getId() == R.id.btn_sign_up) {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        }
    }

}
