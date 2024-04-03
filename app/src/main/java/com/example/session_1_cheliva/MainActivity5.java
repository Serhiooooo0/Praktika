// 02.04.2024 Челогузов Сергей Дмитриевич Класс описывает создание аккаунта
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity5 extends AppCompatActivity {

    private AppCompatButton login;
    private CheckBox terms;
    private String fioText;
    private String phoneText;
    private String emailText;
    private String passText;
    private String confText;
    private EditText email;
    private EditText fio;
    private EditText phone;
    private EditText pass;
    private EditText conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        login = findViewById(R.id.button3);
        fioText = "";
        emailText = "";
        phoneText = "";
        passText = "";
        confText = "";


        fio = findViewById(R.id.editTextText2);
        email = findViewById(R.id.EmailAddres);
        phone = findViewById(R.id.TextPhoned);
        pass = findViewById(R.id.Password);
        conf = findViewById(R.id.Password2);
        terms = findViewById(R.id.checkBox);



        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                emailText = email.getText().toString();
                Validation(emailText, terms);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        terms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                emailText = email.getText().toString();
                Validation(emailText, terms);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fioText = fio.getText().toString();
                phoneText = phone.getText().toString();
                passText = pass.getText().toString();
                confText = conf.getText().toString();


                if(fioText.length() != 0 & Patterns.PHONE.matcher(phoneText).matches() & passText.length() != 0 & confText.length() != 0 & passText.equals(confText) == true){
                    Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                    startActivity(intent);
                }
                if(fioText.length() == 0) {
                    fio.setBackground(getDrawable(R.drawable.okno2));
                } else {
                    fio.setBackground(getDrawable(R.drawable.okno));
                }
                if(Patterns.PHONE.matcher(phoneText).matches()) {
                    phone.setBackground(getDrawable(R.drawable.okno));
                } else {
                    phone.setBackground(getDrawable(R.drawable.okno2));
                }
                if(passText.length() == 0 || passText.equals(confText) == false) {
                    pass.setBackground(getDrawable(R.drawable.okno2));
                } else {
                    pass.setBackground(getDrawable(R.drawable.okno));
                }
                if(confText.length() == 0 || passText.equals(confText) == false) {
                    conf.setBackground(getDrawable(R.drawable.okno2));
                } else {
                    conf.setBackground(getDrawable(R.drawable.okno));
                }
            }
        });
    }
    public void Validation(String email, CheckBox view){
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() & view.isChecked() == true){
            login.setEnabled(true);
            int colorB = Color.parseColor("#0560FA");
            login.setBackgroundColor(colorB);
        } else{
            login.setEnabled(false);
            int colorG = Color.parseColor("#A7A7A7");
            login.setBackgroundColor(colorG);
        }
    }
    public void SignIn(View v){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}
