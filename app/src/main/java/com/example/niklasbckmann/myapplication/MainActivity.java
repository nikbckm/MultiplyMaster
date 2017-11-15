package com.example.niklasbckmann.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {


    Integer result; // Math task as Integer for computer to calculate
    String MathTask; // Math task as string to show to user
    Integer inputNumber;  // number that user types in EditView
    Integer tries = 0; //repetitions
    Integer score = -1; // highscore?
    TextView userInput_textView; //EditText EditText_textfield;
    Button createMathTask_button;
    TextView mathTask_textview;
    TextView score_textview;
    CountDownTimer mCountDownTimer;
    TextView timer_textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput_textView = findViewById(R.id.userInput_textView);
        timer_textView = (TextView) findViewById(R.id.timer_textView);
    }

    public void createMathTask(View view) {      // create simple math task
        mathTask_textview = findViewById(R.id.mathTask_textview);
        createMathTask_button = findViewById(R.id.createMathTask_button);

        if (tries == 0 || userInput_textView.getText().toString().trim().length() > 0) {  //check if EditText has text

            if (tries > 0) {
                inputNumber = Integer.parseInt(userInput_textView.getText().toString());    // so then we got an int to compare
            }

            if (tries == 0) {  // if first try START
                mCountDownTimer = this.createTimer();
                int number1 = (int) (Math.random() * 10) + 1;
                int number2 = (int) (Math.random() * 10) + 1;

                result = number1 * number2; // calc the result
                MathTask = number1 + " * " + number2; // math task as string

                mathTask_textview.setText(MathTask + " = "); //setting the math task to textview
                createMathTask_button.setText("Next!");
                score++;
                score_textview = (TextView) findViewById(R.id.score_textview);
                score_textview.setText("Your score:\n" + score);         //increase score
                userInput_textView.setText("");
            } else if (tries > 0 && tries < 5 && inputNumber == result) {  // if not first try and correct answer
                int number1 = (int) (Math.random() * 10) + 1;
                int number2 = (int) (Math.random() * 10) + 1;

                result = number1 * number2; // calc the result
                MathTask = number1 + " * " + number2; // math task as string

                mathTask_textview.setText(MathTask); //setting the math task to textview
                createMathTask_button.setText("Done!");
                score++;
                TextView score_textview = (TextView) findViewById(R.id.score_textview);
                score_textview.setText("Your score:\n" + score);         //increase score
                userInput_textView.setText("");
            } else if (tries > 4 && tries < 10 && inputNumber == result) {  // difficulty level 2
                int number1 = (int) (Math.random() * 10) + 1;
                int number2 = (int) (Math.random() * 10) + 8;

                result = number1 * number2; // calc the result
                MathTask = number1 + " * " + number2; // math task as string

                mathTask_textview.setText(MathTask); //setting the math task to textview
                createMathTask_button.setText("Done!");
                score++;
                TextView score_textview = (TextView) findViewById(R.id.score_textview);
                score_textview.setText("Your score:\n" + score);         //increase score
                userInput_textView.setText("");
            } else if (tries > 9 && inputNumber == result) {  // difficulty level 2
                int number1 = (int) (Math.random() * 10) + 10;
                int number2 = (int) (Math.random() * 10) + 6;

                result = number1 * number2; // calc the result
                MathTask = number1 + " * " + number2; // math task as string

                mathTask_textview.setText(MathTask); //setting the math task to textview
                createMathTask_button.setText("Next Task!");
                score++;
                TextView score_textview = (TextView) findViewById(R.id.score_textview);
                score_textview.setText("Your score:\n" + score);         //increase score
                userInput_textView.setText("");
            } else if (inputNumber != result && inputNumber != null) {
                TextView h1 = (TextView) findViewById(R.id.h1);
                endOfGame();
            }

            tries++; // every time a new math task generates u get another try
        }
    }

        public CountDownTimer createTimer() {
            return new CountDownTimer(60000, 1000) {

                public void onTick(long millisUntilFinished) {
                    timer_textView.setText("Time left:\n" + millisUntilFinished / 1000 +"s");
                }

                public void onFinish() {
                    endOfGame();
                    //time_over=true;
                }
            }.start();
        }


     public void endOfGame(){
         mCountDownTimer.cancel();
         timer_textView.setText("End of Game!");
         score_textview.setText("Last score:\n"+score);
         createMathTask_button.setText("Restart");
         mathTask_textview.setText("Restart?");
         Intent myIntent = new Intent(this, DisplayScore.class);
         myIntent.putExtra("intVariableName", score);
         startActivity(myIntent);
         tries=0;
         score=0;
     }


    public void btn_zero(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("0");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "0");
        }
    }
     public void btn_one(View view){
         userInput_textView = findViewById(R.id.userInput_textView);
         if(userInput_textView.getText().equals("")){
             userInput_textView.setText("1");
         } else {
             int x = Integer.parseInt(userInput_textView.getText().toString());
             userInput_textView.setText(x + "1");
         }
     }
    public void btn_two(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("2");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "2");
        }
    }

    public void btn_three(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("3");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "3");
        }
    }
    public void btn_four(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("4");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "4");
        }
    }
    public void btn_five(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("5");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "5");
        }
    }
    public void btn_six(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("6");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "6");
        }
    }
    public void btn_seven(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("7");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "7");
        }
    }
    public void btn_eight(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("8");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "8");
        }
    }
    public void btn_nine(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        if(userInput_textView.getText().equals("")){
            userInput_textView.setText("9");
        } else {
            int x = Integer.parseInt(userInput_textView.getText().toString());
            userInput_textView.setText(x + "9");
        }
    }
    public void btn_back(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        userInput_textView.setText("");

    }


}