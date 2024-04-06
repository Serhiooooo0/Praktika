package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity16 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        TextView place = findViewById(R.id.place);
        TextView phon = findViewById(R.id.phon);
        TextView placetrakc = findViewById(R.id.placetrakc);
        TextView phonetrack = findViewById(R.id.phonetrack);
        TextView weight = findViewById(R.id.weight);
        TextView worth = findViewById(R.id.worth);
        TextView item = findViewById(R.id.item);

        Bundle arg = getIntent().getExtras();

        place.setText(arg.getString("place"));
        phon.setText(arg.getString("phon"));
        placetrakc.setText(arg.getString("placetrakc"));
        phonetrack.setText(arg.getString("phonetrack"));
        weight.setText(arg.getString("weight"));
        worth.setText(arg.getString("worth"));
        item.setText(arg.getString("item"));



    }

    public void Back(View v){
        Intent intent = new Intent(this, MainActivity11.class);
        startActivity(intent);
    }
    public void Make(View view){
        Intent intent = new Intent(this, MainActivity17.class);
        startActivity(intent);
    }
    public void Edit(View view){
        Intent intent = new Intent(this, MainActivity15.class);
        startActivity(intent);
    }
}