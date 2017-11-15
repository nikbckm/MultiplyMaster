package com.example.niklasbckmann.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class DisplayScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);

        // Get the Intent that started this activity and extract the string

        String highscore;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                highscore = null;
            } else {
                highscore = extras.getString("HIGHSCORE");
            }
        } else {
            highscore = (String) savedInstanceState.getSerializable("HIGHSCORE");
        }


        // Capture the layout's TextView and set the string as its text
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);
        highscore = "Your Score: " + intValue;

        TextView finalScore_textview = findViewById(R.id.finalScore_textview);
        finalScore_textview.setText(highscore);
    }
}
