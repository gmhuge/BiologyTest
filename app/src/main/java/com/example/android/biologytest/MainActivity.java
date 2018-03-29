package com.example.android.biologytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

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
}
