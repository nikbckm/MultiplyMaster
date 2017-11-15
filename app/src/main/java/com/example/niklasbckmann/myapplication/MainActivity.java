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
    Integer score = -1; // highscore?
    TextView userInput_textView; //EditText EditText_textfield;
    Button createMathTask_button;
    TextView mathTask_textview;
    TextView score_textview;
    CountDownTimer mCountDownTimer;
    TextView timer_textView;
    Boolean GameEnded = false;
    Integer personal_highscore=0;
    Boolean wrong_result;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput_textView = findViewById(R.id.userInput_textView);
        timer_textView = (TextView) findViewById(R.id.timer_textView);
        disableButtons();

    }

    public void createMathTask(View view) {      // create simple math task
        mathTask_textview = findViewById(R.id.mathTask_textview);
        createMathTask_button = findViewById(R.id.createMathTask_button);
        enableButtons();


        if (score == -1 || userInput_textView.getText().toString().trim().length() > 0) {  //check if EditText has text

            if (score > -1) {
                inputNumber = Integer.parseInt(userInput_textView.getText().toString());    // so then we got an int to compare
            }

            if (score == -1 || GameEnded) {  // if first try START   OR   GameEnded

                mCountDownTimer = this.createTimer();
                int number1 = (int) (Math.random() * 6) + 1;
                int number2 = (int) (Math.random() * 6) + 1;

                result = number1 * number2; // calc the result
                MathTask = number1 + " * " + number2; // math task as string

                mathTask_textview.setText(MathTask + " = "); //setting the math task to textview
                createMathTask_button.setText("Next!");
                score++;
                score_textview = (TextView) findViewById(R.id.score_textview);
                score_textview.setText("Your score:\n" + score);         //increase score
                userInput_textView.setText("");

                    if (GameEnded) {
                        GameEnded=false;
                    }
            }

            if (inputNumber != result && inputNumber != null) {             //if answer is wrong!
                wrong_result=true;
                endOfGame();
            }

            if (score >= 0 && score <= 5 && inputNumber == result) {  // if not first try and correct answer
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

            }

            if (score > 5 && inputNumber == result) {  // if not first try and correct answer
                int number1 = (int) (Math.random() * 19) + 1;
                int number2 = (int) (Math.random() * 19) + 1;

                result = number1 * number2; // calc the result
                MathTask = number1 + " * " + number2; // math task as string

                mathTask_textview.setText(MathTask); //setting the math task to textview
                createMathTask_button.setText("Done!");
                TextView score_textview = (TextView) findViewById(R.id.score_textview);
                score++;
                score_textview.setText("Your score:\n" + score);         //increase score
                userInput_textView.setText("");

            }
        }
    }

        public CountDownTimer createTimer() {
                return new CountDownTimer(30000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        timer_textView.setText("Time left:\n" + millisUntilFinished / 1000 + "s");
                    }

                    public void onFinish() {                        //if game is over mCountDownTimer.cancel();
                        wrong_result=false;
                        endOfGame();
                    }
                }.start();
        }

    public void endOfGame() {
        if(wrong_result){
            mathTask_textview.setText("You did a mistake! Restart?");
        } else {
            mathTask_textview.setText("Time over. Restart?");
        }
        inputNumber=null;
        mCountDownTimer.cancel();
        timer_textView.setText("End of Game!");

        createMathTask_button.setText("Restart!");
        if (score>personal_highscore) {
            personal_highscore=score;
            TextView highscore_textview = findViewById(R.id.highscore_textview);
            highscore_textview.setText("Highscore:\n"+personal_highscore);
            userInput_textView.setText("New highscore: "+personal_highscore+". Congrats!");
        }

        score=-1;
        GameEnded = true;
        wrong_result=false;
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
        String str = userInput_textView.getText().toString();

        if (str.length() > 0 ) {
            str = str.substring(0, str.length() - 1);
            userInput_textView.setText(str);
        }

    }

    public void btn_cancel(View view){
        userInput_textView = findViewById(R.id.userInput_textView);
        userInput_textView.setText("");

    }

    public void disableButtons(){
        Button btn_one = (Button) findViewById(R.id.btn_one);               //disable buttons
        btn_one.setEnabled(false);
        Button btn_two = (Button) findViewById(R.id.btn_two);               //disable buttons
        btn_two.setEnabled(false);
        Button btn_three = (Button) findViewById(R.id.btn_three);               //disable buttons
        btn_three.setEnabled(false);
        Button btn_four = (Button) findViewById(R.id.btn_four);               //disable buttons
        btn_four.setEnabled(false);
        Button btn_five = (Button) findViewById(R.id.btn_five);               //disable buttons
        btn_five.setEnabled(false);
        Button btn_six = (Button) findViewById(R.id.btn_six);               //disable buttons
        btn_six.setEnabled(false);
        Button btn_seven = (Button) findViewById(R.id.btn_seven);               //disable buttons
        btn_seven.setEnabled(false);
        Button btn_eight = (Button) findViewById(R.id.btn_eight);               //disable buttons
        btn_eight.setEnabled(false);
        Button btn_nine = (Button) findViewById(R.id.btn_nine);               //disable buttons
        btn_nine.setEnabled(false);
        Button btn_zero = (Button) findViewById(R.id.btn_zero);               //disable buttons
        btn_zero.setEnabled(false);
        Button btn_back = (Button) findViewById(R.id.btn_back);               //disable buttons
        btn_back.setEnabled(false);
        Button btn_cancel = (Button) findViewById(R.id.btn_cancel);               //disable buttons
        btn_cancel.setEnabled(false);
    }

    public void enableButtons(){
        Button btn_one = (Button) findViewById(R.id.btn_one);               //disable buttons
        btn_one.setEnabled(true);
        Button btn_two = (Button) findViewById(R.id.btn_two);               //disable buttons
        btn_two.setEnabled(true);
        Button btn_three = (Button) findViewById(R.id.btn_three);               //disable buttons
        btn_three.setEnabled(true);
        Button btn_four = (Button) findViewById(R.id.btn_four);               //disable buttons
        btn_four.setEnabled(true);
        Button btn_five = (Button) findViewById(R.id.btn_five);               //disable buttons
        btn_five.setEnabled(true);
        Button btn_six = (Button) findViewById(R.id.btn_six);               //disable buttons
        btn_six.setEnabled(true);
        Button btn_seven = (Button) findViewById(R.id.btn_seven);               //disable buttons
        btn_seven.setEnabled(true);
        Button btn_eight = (Button) findViewById(R.id.btn_eight);               //disable buttons
        btn_eight.setEnabled(true);
        Button btn_nine = (Button) findViewById(R.id.btn_nine);               //disable buttons
        btn_nine.setEnabled(true);
        Button btn_zero = (Button) findViewById(R.id.btn_zero);               //disable buttons
        btn_zero.setEnabled(true);
        Button btn_back = (Button) findViewById(R.id.btn_back);               //disable buttons
        btn_back.setEnabled(true);
        Button btn_cancel = (Button) findViewById(R.id.btn_cancel);               //disable buttons
        btn_cancel.setEnabled(true);
    }


}