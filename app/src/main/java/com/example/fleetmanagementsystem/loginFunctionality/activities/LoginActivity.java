package com.example.fleetmanagementsystem.loginFunctionality.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fleetmanagementsystem.InputValidation;
import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.homeFunctionality.HomeActivity;
import com.example.fleetmanagementsystem.Constants.ObserverStringResponse;
import com.example.fleetmanagementsystem.loginFunctionality.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    LoginViewModel loginViewModel;
    ProgressBar loginPrgressbar;
    //to handle if user clicked multible times
    boolean isClicked;
    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.email_et);
        passwordEditText = findViewById(R.id.pass_et);
        loginPrgressbar = findViewById(R.id.loginProgressBar);
        isClicked=false;
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.loginSubject
                .subscribe(
                        result -> {
                            loginPrgressbar.setVisibility(View.GONE);
                            if (result.equals(ObserverStringResponse.SUCCESS_RESPONSE)) {
                                Toast.makeText(this, "User signed in ", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                                isClicked=false;
                            }
                        }
                );
    }

    public void loginBtnClicked(View view) {
        if(InputValidation.emailValidation(emailEditText)&&InputValidation.validatePassword(passwordEditText)&&!isClicked) {
            loginViewModel.doLogin(emailEditText.getText().toString(), passwordEditText.getText().toString());
            loginPrgressbar.setVisibility(View.VISIBLE);
            isClicked=true;
        }
    }


}
