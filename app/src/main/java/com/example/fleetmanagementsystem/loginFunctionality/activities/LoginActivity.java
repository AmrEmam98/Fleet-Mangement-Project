package com.example.fleetmanagementsystem.loginFunctionality.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.SplashActivity;
import com.example.fleetmanagementsystem.homeFunctionality.activities.HomeActivity;
import com.example.fleetmanagementsystem.loginFunctionality.ResponseConstants.LoginObserverResponse;
import com.example.fleetmanagementsystem.loginFunctionality.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    LoginViewModel loginViewModel;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        emailEditText = findViewById(R.id.email_et);
        passwordEditText = findViewById(R.id.pass_et);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginViewModel.loginSubject
                .subscribe(
                        result -> {
                            if (result.equals(LoginObserverResponse.SUCCESS_RESPONSE)) {
                                Toast.makeText(this, "User signed in ", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, result, Toast.LENGTH_LONG).show();
                            }
                        }
                );
    }

    public void loginBtnClicked(View view) {
        if (isEmpty(emailEditText, passwordEditText)) {
            Toast.makeText(this, "Please Fill All Fields ", Toast.LENGTH_LONG).show();
        } else {

            loginViewModel.doLogin(emailEditText.getText().toString(), passwordEditText.getText().toString());

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private boolean isEmpty(EditText emailEt, EditText passEt) {
        boolean empty = false;
        if (emailEt.getText().toString().trim().length() == 0 || passEt.getText().toString().trim().length() == 0) {
            empty = true;
        }
        return empty;
    }
}
