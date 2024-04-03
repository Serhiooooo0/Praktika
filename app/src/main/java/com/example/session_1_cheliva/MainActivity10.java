// 02.04.2024 Челогузов Сергей Дмитриевич Класс описывает ввод нового пароля
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity10 extends AppCompatActivity {

    private AppCompatButton log;
    private String confText;
    private String passText;

    private EditText conf;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        log = findViewById(R.id.buttonlog);
        passText = "";
        confText = "";

        pass = findViewById(R.id.editEmailAddress);
        conf = findViewById(R.id.Parol);


        conf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                confText = conf.getText().toString();
                passText = pass.getText().toString();
                Validation(confText, passText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                confText = conf.getText().toString();
                passText = pass.getText().toString();
                Validation(confText, passText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void Validation(String conf, String pass){
        if (conf.length()!=0 & pass.length() != 0 & pass.equals(conf) == true){
            log.setEnabled(true);
            int colorB = Color.parseColor("#0560FA");
            log.setBackgroundColor(colorB);
        } else{
            log.setEnabled(false);
            int colorG = Color.parseColor("#A7A7A7");
            log.setBackgroundColor(colorG);
        }
    }


}