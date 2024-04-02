package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        final int[] time = {59};
        TextView textTimer = (TextView) findViewById(R.id.textView23);
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textTimer.setText("resend after" + " 0:"+checkDigit(time[0]));
                time[0]--;
            }
            public void onFinish() {
                textTimer.setText("Send the verification code again");
            }
        }.start();
    }
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void Password(View view){
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }
}