package com.example.fleetmanagementsystem.splashScreens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fleetmanagementsystem.R;
import com.example.fleetmanagementsystem.homeFunctionality.HomeActivity;
import com.example.fleetmanagementsystem.loginFunctionality.activities.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3500;

    Animation topAnim, bottomAnim;
    ImageView splashImage;
    TextView splashText1, splashText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        splashImage = findViewById(R.id.splashImage);
        splashText1 = findViewById(R.id.splashText1);
        splashText2 = findViewById(R.id.splashText2);

        splashImage.setAnimation(topAnim);
        splashText1.setAnimation(bottomAnim);
        splashText2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                if(FirebaseAuth.getInstance().getCurrentUser()!=null) {
                    intent = new Intent(SplashActivity.this, HomeActivity.class);
                }
                else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }

                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}

