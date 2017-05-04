package com.base111.basis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MathQuiz extends AppCompatActivity {

    TextView questionScore;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        questionScore = (TextView) findViewById(R.id.questionScore);
    }//end of on create method


    //method for question one oooooooo
    public void Q1(View view){

        questionScore.setText("Score: "+String.valueOf(score));
        //is radio button checked?
        boolean checked = ((RadioButton) view).isChecked();

        //which button was checked
        switch (view.getId()) {
            case R.id.mathQ1a:
                Toast.makeText(getApplicationContext(),"Wrong! ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mathQ1b:
                Toast.makeText(getApplicationContext(),"Wrong!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mathQ1c:
                Toast.makeText(getApplicationContext(),"That's Correct!",Toast.LENGTH_SHORT).show();
                score++;
                questionScore.setText("Score: "+String.valueOf(score));
                break;
        }

    }//end of Q1 method


    //dummy method for question nav..would start new activity or fragment?
    public void Q2(View view){
        Toast.makeText(getApplicationContext(),"Moving to next question..",Toast.LENGTH_SHORT).show();
    }

}
