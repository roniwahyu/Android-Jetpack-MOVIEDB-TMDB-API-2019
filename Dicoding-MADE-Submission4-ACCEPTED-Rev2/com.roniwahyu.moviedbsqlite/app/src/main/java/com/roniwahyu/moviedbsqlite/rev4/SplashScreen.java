package com.roniwahyu.moviedbsqlite.rev4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int loadingTime = 2000;
        new Handler().postDelayed(() -> {
            Intent main = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(main);
            finish();
        }, loadingTime);
    }
}
