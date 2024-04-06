// 02.04.2024 Челогузов Сергей Дмитриевич Класс описывает ввод полученного кода для изменения пароля
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity {

    private EditText one;
    private EditText two;
    private EditText three;
    private EditText four;
    private EditText five;
    private EditText six;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        one = findViewById(R.id.Text1);

        two = findViewById(R.id.Text2);

        three = findViewById(R.id.Text3);

        four = findViewById(R.id.Text4);

        five = findViewById(R.id.Text5);

        six = findViewById(R.id.Text6);

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
        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(one.length() == 1){
                    two.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        two.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(two.length() == 1){
                    three.requestFocus();
                }
                if(two.length() == 0){
                    one.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        three.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(three.length() == 1){
                    four.requestFocus();
                }
                if(three.length() == 0){
                    two.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        four.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(four.length() == 1){
                    five.requestFocus();
                }
                if(four.length() == 0){
                    three.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        five.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(five.length() == 1){
                    six.requestFocus();
                }
                if(five.length() == 0){
                    four.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        six.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(six.length() == 0){
                    five.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void SET(View view){
        Intent intent = new Intent(this, MainActivity10.class);
        startActivity(intent);
    }
}