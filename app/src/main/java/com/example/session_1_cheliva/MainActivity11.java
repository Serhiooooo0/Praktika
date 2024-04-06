package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
    }
    public void Profile(View view){
        Intent intent = new Intent(this, MainActivity12.class);
        startActivity(intent);
    }
    public void Track(View view){
        Intent intent = new Intent(this, MainActivity18.class);
        startActivity(intent);
    }
    public void Walet(View view){
        Intent intent = new Intent(this, MainActivity19.class);
        startActivity(intent);
    }
}