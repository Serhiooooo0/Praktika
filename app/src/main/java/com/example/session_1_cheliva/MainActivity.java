// 01.04.2024 Челогузов Сергей Дмитриевич Главный экран приложения
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // класс создан для перехода на заданный активити с определенным интервалом
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
            }, 1000);
    }
    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}