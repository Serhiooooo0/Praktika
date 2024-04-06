// 01.04.2024 Челогузов Сергей Дмитриевич
package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    // метод для перехода на следующий активити для кнопки
    public void SignUp(View v){
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
    public void SignIn(View v){
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }
}