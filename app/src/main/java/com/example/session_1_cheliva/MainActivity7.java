// 02.04.2024 Челогузов Сергей Дмитриевич Класс описывает получение кода для изменения пароля вводя почту
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

public class MainActivity7 extends AppCompatActivity {

    private AppCompatButton send;
    private String emailText;
    private EditText email;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        send = findViewById(R.id.buttonSend);

        emailText = "";
        email = findViewById(R.id.Email);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailText = email.getText().toString();
                validateMail(emailText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void validateMail(String email){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            send.setEnabled(true);
            int colorB = Color.parseColor("#0560FA");
            send.setBackgroundColor(colorB);
        }
        else{
            send.setEnabled(false);
            int colorG = Color.parseColor("#A7A7A7");
            send.setBackgroundColor(colorG);
        }
    }
    public void SignUp(View v){
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    public void SendOTP(View v){
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }
}