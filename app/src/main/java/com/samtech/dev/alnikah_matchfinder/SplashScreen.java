package com.samtech.dev.alnikah_matchfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {


    Animation topAnimation , BottomAnimation;
    TextView logotextView;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN  );
        setContentView(R.layout.activity_splash_screen);

        topAnimation = AnimationUtils.loadAnimation(this , R.anim.top_animation);
        BottomAnimation = AnimationUtils.loadAnimation(this , R.anim.bottom_anim);

        logo = findViewById(R.id.logo);
        logotextView = findViewById(R.id.logoText);
        logo.setAnimation(topAnimation);
        logotextView.setAnimation(BottomAnimation);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this , LoginActivity.class);


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Pair[] pairs = new Pair[1];
                    pairs[0]  = new Pair<View , String>(logo , "logo_image");
                    ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,pairs);
                    startActivity(intent,options.toBundle());
                    finish();
                }
                else{
                    startActivity(intent);
                    finish();
                }
            }
        }, 5000);



    }
}