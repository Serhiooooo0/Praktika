package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity12 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
    }
    public void Statements(View view){
        Intent intent = new Intent(this, MainActivity15.class);
        startActivity(intent);
    }
    public void LogOut(View view){
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }
    public void Notification(View view){
        Intent intent = new Intent(this, MainActivity14.class);
        startActivity(intent);
    }
    public void AddPay(View view){
        Intent intent = new Intent(this, MainActivity13.class);
        startActivity(intent);
    }
    public void Home(View v){
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }
}


