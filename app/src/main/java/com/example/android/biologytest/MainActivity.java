package com.example.android.biologytest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_QUIZ_NUMBER_VALUE = 4;
    int quizStatus = 0;
    int correctAnswers = 0;
    int count;
    RadioGroup radio1;
    RadioGroup radio2;


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
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio1.clearCheck();
        radio2.clearCheck();

        clearCheckBox(R.id.check3_1);
        clearCheckBox(R.id.check3_2);
        clearCheckBox(R.id.check3_3);
        clearCheckBox(R.id.check3_4);

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
                checkRadio4submit(R.id.quiz1submit, radio1, R.id.next1, R.id.radio1_2 );
                break;
            case R.id.quiz2submit:
                checkRadio4submit(R.id.quiz2submit, radio2, R.id.next2, R.id.radio2_1 );
            break;
            case R.id.quiz3submit:
                int[] checkedBoxId3 = new int[4];
                checkedBoxId3[0] = checkBoxIsChecked(R.id.check3_1);
                checkedBoxId3[1] = checkBoxIsChecked(R.id.check3_2);
                checkedBoxId3[2] = checkBoxIsChecked(R.id.check3_3);
                checkedBoxId3[3] = checkBoxIsChecked(R.id.check3_4);
                int[] correctAnswersId3 = {R.id.check3_1, R.id.check3_2,0,0};
                checkBox4submit(R.id.quiz3submit,checkedBoxId3,R.id.next3,correctAnswersId3);
                break;
        }

    }

    private void checkRadio4submit (int submButtontId, RadioGroup radioGroup, int nextButtonId, int correctAnswerId) {
        boolean submitFlag = false;
        int checkedRadioId = radioGroup.getCheckedRadioButtonId();
        Button buttonSubmit = findViewById(submButtontId);
        Button buttonNext = findViewById(nextButtonId);
        if (checkedRadioId == correctAnswerId) {
            buttonSubmit.setText("RIGHT");
            buttonSubmit.setBackgroundColor(Color.GREEN);
            correctAnswers++;
            submitFlag = true;
        }
        else if (checkedRadioId == -1) {
            Toast.makeText(getApplicationContext(), "Please select answer", Toast.LENGTH_SHORT).show();
        }
        else {
            buttonSubmit.setText("WRONG");
            buttonSubmit.setBackgroundColor(Color.RED);
            submitFlag = true;
        }
        if (submitFlag) {
            buttonSubmit.setClickable(false);
            buttonNext.setVisibility(View.VISIBLE);
        }

    }

    private void checkBox4submit (int submButtontId, int[] checkedBoxId, int nextButtonId, int[] correctAnswerId) {
        boolean submitFlag = false;
        Button buttonSubmit = findViewById(submButtontId);
        Button buttonNext = findViewById(nextButtonId);

        if (Arrays.equals(checkedBoxId, correctAnswerId)) {
            buttonSubmit.setText("RIGHT");
            buttonSubmit.setBackgroundColor(Color.GREEN);
            correctAnswers++;
            submitFlag = true;
        }
        else {
            buttonSubmit.setText("WRONG");
            buttonSubmit.setBackgroundColor(Color.RED);
            submitFlag = true;
        }
        if (submitFlag) {
            buttonSubmit.setClickable(false);
            buttonNext.setVisibility(View.VISIBLE);
        }

    }

    private int checkBoxIsChecked (int checkBoxId) {
        CheckBox checkBox = findViewById(checkBoxId);
        if (checkBox.isChecked()) {
            return checkBoxId;
        }
        else {
            return 0;
        }
    }

    private void  clearCheckBox (int checkBoxId) {
        CheckBox checkBox = findViewById(checkBoxId);
        checkBox.setChecked(false);
    }
}
