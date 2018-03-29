package com.example.android.biologytest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_QUIZ_NUMBER_VALUE = 4;
    int quizStatus = 0;
    int correctAnswers = 0;
    int count;

    int[] quizes = {R.id.quiz0,R.id.quiz1,R.id.quiz2,R.id.quiz3,R.id.quiz4};
    ScrollView[] quizViews = new ScrollView[MAX_QUIZ_NUMBER_VALUE+1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {
        quizStatus = 0;
        correctAnswers = 0;

        for (count = 0; count <= MAX_QUIZ_NUMBER_VALUE; count++) {
            quizViews[count] = findViewById(quizes[count]);
        }

        activateQuizView(0);
    }

    private void activateQuizView(int number){
        for (count = 0; count <= MAX_QUIZ_NUMBER_VALUE; count++) {
            quizViews[count].setVisibility(View.GONE);
        }
        quizViews[number].setVisibility(View.VISIBLE);
    }

    public void nextQuiz(View view) {
        if (quizStatus < MAX_QUIZ_NUMBER_VALUE){
            quizStatus++;
            activateQuizView(quizStatus);
        }
    }

    public void submitQuiz(View view){

        switch (view.getId()){
            case R.id.quiz1submit:
                RadioGroup radio1 = findViewById(R.id.radio1);
                int checkedRadio1Id = radio1.getCheckedRadioButtonId();
                Button buttonSubmit1 = findViewById(R.id.quiz1submit);
                Button buttonNext1 = findViewById(R.id.next1);
                if (checkedRadio1Id == R.id.radio1_2) {
                    buttonSubmit1.setText("RIGHT");
                    buttonSubmit1.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                }
                else {
                    buttonSubmit1.setText("WRONG");
                    buttonSubmit1.setBackgroundColor(Color.RED);
                }
                buttonSubmit1.setClickable(false);
                buttonNext1.setVisibility(View.VISIBLE);
            break;
            case R.id.quiz2submit:
                RadioGroup radio2 = findViewById(R.id.radio2);
                int checkedRadio2Id = radio2.getCheckedRadioButtonId();
                Button buttonSubmit2 = findViewById(R.id.quiz2submit);
                Button buttonNext2 = findViewById(R.id.next2);
                if (checkedRadio2Id == R.id.radio2_1) {
                    buttonSubmit2.setText("RIGHT");
                    buttonSubmit2.setBackgroundColor(Color.GREEN);
                    correctAnswers++;
                }
                else {
                    buttonSubmit2.setText("WRONG");
                    buttonSubmit2.setBackgroundColor(Color.RED);
                }
                buttonSubmit2.setClickable(false);
                buttonNext2.setVisibility(View.VISIBLE);
            break;
        }

    }
}
