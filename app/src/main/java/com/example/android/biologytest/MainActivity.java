package com.example.android.biologytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    int quizStatus = 0;
    int correctAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quizStatus = 0;
        correctAnswers = 0;



    }


    private void setQuizStatus(int quizStatus) {

        ScrollView quiz0 = findViewById(R.id.quiz0);
        quiz0.setVisibility(View.VISIBLE);
    }
}
