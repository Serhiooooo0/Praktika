package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity17 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);

        ImageView anim = findViewById(R.id.anim);

        anim.setBackgroundResource(R.drawable.anim);

        AnimationDrawable frameAnimation = (AnimationDrawable) anim.getBackground();

        new CountDownTimer(1250, 1000) {

            public void onTick(long millisUntilFinished) {
                frameAnimation.start();
            }

            public void onFinish() {
                frameAnimation.stop();
                anim.setBackground(getDrawable(R.drawable.sucsesfultwo));
                TextView suc = findViewById(R.id.confirm);
                suc.setText("Transaction Successful");
            }
        }.start();
    }

    public void Track(View v){
        Intent intent = new Intent(this, MainActivity18.class);
        startActivity(intent);
    }

    public void Home(View v){
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }
}