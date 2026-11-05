package com.example.bomba2;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logo = findViewById(R.id.imgLogo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        logo.startAnimation(animation);

        splashThread = new Thread(() -> {
            try {
                Thread.sleep(2200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            runOnUiThread(() -> {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            });
        });
        splashThread.start();
    }

    @Override
    protected void onDestroy() {
        if (splashThread != null) {
            splashThread.interrupt();
        }
        super.onDestroy();
    }
}
