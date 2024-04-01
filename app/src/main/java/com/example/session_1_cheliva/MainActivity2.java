// 01.04.2024 Челогузов Сергей Дмитриевич
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    // метод для перехода на следующий активити для кнопки
    public void Skip2(View v){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void Next2(View v){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

}