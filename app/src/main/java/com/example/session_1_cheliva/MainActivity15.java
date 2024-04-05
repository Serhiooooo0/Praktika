package com.example.session_1_cheliva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity15 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
        LinearLayout shed = findViewById(R.id.shed);
        LinearLayout ins = findViewById(R.id.ins);
        TextView textclock = findViewById(R.id.textclock);
        TextView textcalend = findViewById(R.id.textcalend);
        ImageView clock = findViewById(R.id.clock);
        ImageView calend = findViewById(R.id.calend);



        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ins.setBackground(getDrawable(R.drawable.fullblue));
                shed.setBackground(getDrawable(R.drawable.okno));
                textclock.setTextColor(getColor(R.color.white));
                textcalend.setTextColor(getColor(R.color.gray));
                clock.setImageDrawable(getDrawable(R.drawable.clock));
                calend.setImageDrawable(getDrawable(R.drawable.calendar));
            }
        });

        shed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shed.setBackground(getDrawable(R.drawable.fullblue));
                ins.setBackground(getDrawable(R.drawable.okno));
                textclock.setTextColor(getColor(R.color.gray));
                textcalend.setTextColor(getColor(R.color.white));
                clock.setImageDrawable(getDrawable(R.drawable.clockgray));
                calend.setImageDrawable(getDrawable(R.drawable.calenwithe));
            }
        });


    }

    public void Next(View v){
        EditText address = findViewById(R.id.address);
        EditText town = findViewById(R.id.town);
        EditText phoneinfo = findViewById(R.id.phoneinfo);

        EditText addresspoint1 = findViewById(R.id.addresspoint1);
        EditText townpoint1 = findViewById(R.id.townpoint1);
        EditText phoneinfopoint1 = findViewById(R.id.phoneinfopoint1);

        EditText items = findViewById(R.id.items);
        EditText weightit = findViewById(R.id.weightpack);
        EditText worthit = findViewById(R.id.worthpack);

        Intent intent = new Intent(this, MainActivity16.class);
        String placetext = address.getText().toString() +" " + town.getText().toString();
        String placetracktext = addresspoint1.getText().toString() +" " + townpoint1.getText().toString();
        intent.putExtra("place", placetext);
        intent.putExtra("phon", phoneinfo.getText().toString());
        intent.putExtra("placetrakc", placetracktext);
        intent.putExtra("phonetrack", phoneinfopoint1.getText().toString());
        intent.putExtra("item", items.getText().toString());
        intent.putExtra("weight", weightit.getText().toString());
        intent.putExtra("worth", worthit.getText().toString());

        startActivity(intent);
    }
    public void Back(View v){
        Intent intent = new Intent(this, MainActivity12.class);
        startActivity(intent);
    }

}