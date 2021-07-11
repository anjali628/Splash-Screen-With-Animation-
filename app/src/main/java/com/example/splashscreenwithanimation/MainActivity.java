package com.example.splashscreenwithanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=2500;

    ImageView imageView;
    TextView textView1,textView2;
    Animation top,bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageview);
        textView1=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);

        top= AnimationUtils.loadAnimation(this,R.anim.top);
        bottom=AnimationUtils.loadAnimation(this,R.anim.bottom);

        imageView.setAnimation(top);
        textView1.setAnimation(bottom);
        textView2.setAnimation(bottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}