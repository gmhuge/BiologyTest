package com.example.android.biologytest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_QUIZ_STATUS = "QUIZ_STATUS";
    private static final String KEY_CORRECT_ANSWERS = "CORRECT_ANSWERS";

    private static final String KEY_SUBMIT1 = "SUBMIT1";
    private static final String KEY_SUBMIT2 = "SUBMIT2";
    private static final String KEY_SUBMIT3 = "SUBMIT3";
    private static final String KEY_SUBMIT4 = "SUBMIT4";
    private static final String KEY_SUBMIT5 = "SUBMIT5";

    private static final int MAX_QUIZ_NUMBER_VALUE = 6;
    int quizStatus = 0;
    int correctAnswers = 0;
    int count;
    RadioGroup radio1;
    RadioGroup radio2;
    EditText edit4;

    int[] quizes = {R.id.quiz0, R.id.quiz1, R.id.quiz2, R.id.quiz3, R.id.quiz4, R.id.quiz5, R.id.quiz6};
    ScrollView[] quizViews = new ScrollView[MAX_QUIZ_NUMBER_VALUE + 1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        edit4 = findViewById(R.id.edit4);

        if (savedInstanceState != null) {

            quizStatus = savedInstanceState.getInt(KEY_QUIZ_STATUS, 0);
            correctAnswers = savedInstanceState.getInt(KEY_CORRECT_ANSWERS, 0);
            if (quizStatus == MAX_QUIZ_NUMBER_VALUE) {
                seeResults();
            }

            for (count = 0; count <= MAX_QUIZ_NUMBER_VALUE; count++) {
                quizViews[count] = findViewById(quizes[count]);
            }

            Button submit1 = findViewById(R.id.quiz1submit);
            Button submit2 = findViewById(R.id.quiz2submit);
            Button submit3 = findViewById(R.id.quiz3submit);
            Button submit4 = findViewById(R.id.quiz4submit);
            Button submit5 = findViewById(R.id.quiz5submit);

            Button next1 = findViewById(R.id.next1);
            Button next2 = findViewById(R.id.next2);
            Button next3 = findViewById(R.id.next3);
            Button next4 = findViewById(R.id.next4);
            Button next5 = findViewById(R.id.next5);

            String submit1Text = savedInstanceState.getString(KEY_SUBMIT1, "");
            String submit2Text = savedInstanceState.getString(KEY_SUBMIT2, "");
            String submit3Text = savedInstanceState.getString(KEY_SUBMIT3, "");
            String submit4Text = savedInstanceState.getString(KEY_SUBMIT4, "");
            String submit5Text = savedInstanceState.getString(KEY_SUBMIT5, "");

            submit1.setText(submit1Text);
            submit2.setText(submit2Text);
            submit3.setText(submit3Text);
            submit4.setText(submit4Text);
            submit5.setText(submit5Text);

            if (submit1Text.equals("RIGHT")) {
                submit1.setClickable(false);
                next1.setVisibility(View.VISIBLE);
                submit1.setBackgroundColor(Color.GREEN);
            }
            if (submit1Text.equals("WRONG")) {
                submit1.setClickable(false);
                next1.setVisibility(View.VISIBLE);
                submit1.setBackgroundColor(Color.RED);
            }
            if (submit1Text.equals("SUBMIT")) {
                submit1.setClickable(true);
                next1.setVisibility(View.GONE);
                submit1.setBackgroundColor(Color.LTGRAY);
            }

            if (submit2Text.equals("RIGHT")) {
                submit2.setClickable(false);
                next2.setVisibility(View.VISIBLE);
                submit2.setBackgroundColor(Color.GREEN);
            }
            if (submit2Text.equals("WRONG")) {
                submit2.setClickable(false);
                next2.setVisibility(View.VISIBLE);
                submit2.setBackgroundColor(Color.RED);
            }
            if (submit2Text.equals("SUBMIT")) {
                submit2.setClickable(true);
                next2.setVisibility(View.GONE);
                submit2.setBackgroundColor(Color.LTGRAY);
            }
            if (submit3Text.equals("RIGHT")) {
                submit3.setClickable(false);
                next3.setVisibility(View.VISIBLE);
                submit3.setBackgroundColor(Color.GREEN);
            }
            if (submit3Text.equals("WRONG")) {
                submit3.setClickable(false);
                next3.setVisibility(View.VISIBLE);
                submit3.setBackgroundColor(Color.RED);
            }
            if (submit3Text.equals("SUBMIT")) {
                submit3.setClickable(true);
                next3.setVisibility(View.GONE);
                submit3.setBackgroundColor(Color.LTGRAY);
            }

            if (submit4Text.equals("RIGHT")) {
                submit4.setClickable(false);
                next4.setVisibility(View.VISIBLE);
                submit4.setBackgroundColor(Color.GREEN);
            }
            if (submit4Text.equals("WRONG")) {
                submit4.setClickable(false);
                next4.setVisibility(View.VISIBLE);
                submit4.setBackgroundColor(Color.RED);
            }
            if (submit4Text.equals("SUBMIT")) {
                submit4.setClickable(true);
                next4.setVisibility(View.GONE);
                submit4.setBackgroundColor(Color.LTGRAY);
            }

            if (submit5Text.equals("RIGHT")) {
                submit5.setClickable(false);
                next5.setVisibility(View.VISIBLE);
                submit5.setBackgroundColor(Color.GREEN);
            }
            if (submit5Text.equals("WRONG")) {
                submit5.setClickable(false);
                next5.setVisibility(View.VISIBLE);
                submit5.setBackgroundColor(Color.RED);
            }
            if (submit5Text.equals("SUBMIT")) {
                submit5.setClickable(true);
                next5.setVisibility(View.GONE);
                submit5.setBackgroundColor(Color.LTGRAY);
            }
            activateQuizView(quizStatus);
        } else {
            initialize();
            activateQuizView(0);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_QUIZ_STATUS, quizStatus);
        outState.putInt(KEY_CORRECT_ANSWERS, correctAnswers);

        Button submit1 = findViewById(R.id.quiz1submit);
        Button submit2 = findViewById(R.id.quiz2submit);
        Button submit3 = findViewById(R.id.quiz3submit);
        Button submit4 = findViewById(R.id.quiz4submit);
        Button submit5 = findViewById(R.id.quiz5submit);

        outState.putString(KEY_SUBMIT1, submit1.getText().toString());
        outState.putString(KEY_SUBMIT2, submit2.getText().toString());
        outState.putString(KEY_SUBMIT3, submit3.getText().toString());
        outState.putString(KEY_SUBMIT4, submit4.getText().toString());
        outState.putString(KEY_SUBMIT5, submit5.getText().toString());
    }

    private void initialize() {
        quizStatus = 0;
        correctAnswers = 0;

        radio1.clearCheck();
        radio2.clearCheck();
        edit4.setText("");

        clearCheckBox(R.id.check3_1);
        clearCheckBox(R.id.check3_2);
        clearCheckBox(R.id.check3_3);
        clearCheckBox(R.id.check3_4);

        clearCheckBox(R.id.check5_1);
        clearCheckBox(R.id.check5_2);
        clearCheckBox(R.id.check5_3);
        clearCheckBox(R.id.check5_4);

        for (count = 0; count <= MAX_QUIZ_NUMBER_VALUE; count++) {
            quizViews[count] = findViewById(quizes[count]);
        }

        clearButtons(R.id.quiz1submit, R.id.next1);
        clearButtons(R.id.quiz2submit, R.id.next2);
        clearButtons(R.id.quiz3submit, R.id.next3);
        clearButtons(R.id.quiz4submit, R.id.next4);
        clearButtons(R.id.quiz5submit, R.id.next5);
    }


    private void activateQuizView(int number) {
        for (count = 0; count <= MAX_QUIZ_NUMBER_VALUE; count++) {
            quizViews[count].setVisibility(View.GONE);
        }
        quizViews[number].setVisibility(View.VISIBLE);
    }

    public void nextQuiz(View view) {
        if (quizStatus < MAX_QUIZ_NUMBER_VALUE) {
            quizStatus++;

            if (quizStatus == MAX_QUIZ_NUMBER_VALUE) {
                seeResults();
            }

            activateQuizView(quizStatus);
        }
    }

    public void submitQuiz(View view) {

        switch (view.getId()) {

            case R.id.quiz1submit:
                checkRadio4submit(R.id.quiz1submit, radio1, R.id.next1, R.id.radio1_2);
                break;
            case R.id.quiz2submit:
                checkRadio4submit(R.id.quiz2submit, radio2, R.id.next2, R.id.radio2_1);
                break;
            case R.id.quiz3submit:
                int[] checkedBoxId3 = new int[4];
                checkedBoxId3[0] = checkBoxIsChecked(R.id.check3_1);
                checkedBoxId3[1] = checkBoxIsChecked(R.id.check3_2);
                checkedBoxId3[2] = checkBoxIsChecked(R.id.check3_3);
                checkedBoxId3[3] = checkBoxIsChecked(R.id.check3_4);
                int[] correctAnswersId3 = {R.id.check3_1, R.id.check3_2, 0, 0};
                checkBox4submit(R.id.quiz3submit, checkedBoxId3, R.id.next3, correctAnswersId3);
                break;
            case R.id.quiz4submit:
                checkEditText4submit(R.id.quiz4submit, edit4, R.id.next4, "australia");
                break;
            case R.id.quiz5submit:
                int[] checkedBoxId5 = new int[4];
                checkedBoxId5[0] = checkBoxIsChecked(R.id.check5_1);
                checkedBoxId5[1] = checkBoxIsChecked(R.id.check5_2);
                checkedBoxId5[2] = checkBoxIsChecked(R.id.check5_3);
                checkedBoxId5[3] = checkBoxIsChecked(R.id.check5_4);
                int[] correctAnswersId5 = {R.id.check5_1, R.id.check5_2, R.id.check5_3, 0};
                checkBox4submit(R.id.quiz5submit, checkedBoxId5, R.id.next5, correctAnswersId5);
                break;
        }

    }

    private void checkRadio4submit(int submButtontId, RadioGroup radioGroup, int nextButtonId, int correctAnswerId) {
        boolean submitFlag = false;
        int checkedRadioId = radioGroup.getCheckedRadioButtonId();
        Button buttonSubmit = findViewById(submButtontId);
        Button buttonNext = findViewById(nextButtonId);
        if (checkedRadioId == correctAnswerId) {
            buttonSubmit.setText(R.string.answer_right);
            buttonSubmit.setBackgroundColor(Color.GREEN);
            correctAnswers++;
            submitFlag = true;
        } else if (checkedRadioId == -1) {
            Toast.makeText(getApplicationContext(), "Please select answer", Toast.LENGTH_SHORT).show();
        } else {
            buttonSubmit.setText(R.string.answer_wrong);
            buttonSubmit.setBackgroundColor(Color.RED);
            submitFlag = true;
        }
        if (submitFlag) {
            buttonSubmit.setClickable(false);
            buttonNext.setVisibility(View.VISIBLE);
        }

    }

    private void checkBox4submit(int submButtontId, int[] checkedBoxId, int nextButtonId, int[] correctAnswerId) {
        boolean submitFlag = false;
        Button buttonSubmit = findViewById(submButtontId);
        Button buttonNext = findViewById(nextButtonId);

        if (Arrays.equals(checkedBoxId, correctAnswerId)) {
            buttonSubmit.setText(R.string.answer_right);
            buttonSubmit.setBackgroundColor(Color.GREEN);
            correctAnswers++;
            submitFlag = true;
        } else if (checkedBoxId[0] == 0 && checkedBoxId[1] == 0 && checkedBoxId[2] == 0 && checkedBoxId[3] == 0) {
            Toast.makeText(getApplicationContext(), "Please select answer", Toast.LENGTH_SHORT).show();
        } else {
            buttonSubmit.setText(R.string.answer_wrong);
            buttonSubmit.setBackgroundColor(Color.RED);
            submitFlag = true;
        }
        if (submitFlag) {
            buttonSubmit.setClickable(false);
            buttonNext.setVisibility(View.VISIBLE);
        }

    }

    private int checkBoxIsChecked(int checkBoxId) {
        CheckBox checkBox = findViewById(checkBoxId);
        if (checkBox.isChecked()) {
            return checkBoxId;
        } else {
            return 0;
        }
    }

    private void clearCheckBox(int checkBoxId) {
        CheckBox checkBox = findViewById(checkBoxId);
        checkBox.setChecked(false);
    }

    private void checkEditText4submit(int submButtontId, EditText edit, int nextButtonId, String correctAnswer) {
        String editTextValue;
        boolean submitFlag = false;
        Button buttonSubmit = findViewById(submButtontId);
        Button buttonNext = findViewById(nextButtonId);

        editTextValue = edit.getText().toString().toLowerCase().trim();

        if (editTextValue.equals(correctAnswer)) {
            buttonSubmit.setText(R.string.answer_right);
            buttonSubmit.setBackgroundColor(Color.GREEN);
            correctAnswers++;
            submitFlag = true;
        } else if (editTextValue.equals("")) {
            Toast.makeText(getApplicationContext(), "Please type answer", Toast.LENGTH_SHORT).show();
        } else {
            buttonSubmit.setText(R.string.answer_wrong);
            buttonSubmit.setBackgroundColor(Color.RED);
            submitFlag = true;
        }
        if (submitFlag) {
            buttonSubmit.setClickable(false);
            buttonNext.setVisibility(View.VISIBLE);
        }
    }

    public void startAgain(View view) {
        initialize();
        activateQuizView(0);
    }

    private void clearButtons(int submitButtonId, int nextButtonId) {
        Button submitButton = findViewById(submitButtonId);
        Button nextButton = findViewById(nextButtonId);

        submitButton.setBackgroundColor(Color.LTGRAY);
        submitButton.setText("SUBMIT");
        submitButton.setClickable(true);

        nextButton.setVisibility(View.INVISIBLE);
    }

    private void seeResults() {
        TextView resultsText = findViewById(R.id.score_results);
        TextView remarkText = findViewById(R.id.remark_results);
        String scoreRemark;

        String numberOfQuiz = Integer.toString(MAX_QUIZ_NUMBER_VALUE - 1);
        String numberOfCorrectAnswers = Integer.toString(correctAnswers);
        String score = numberOfCorrectAnswers.concat("/");
        score = score.concat(numberOfQuiz);
        resultsText.setText(score);

        if (correctAnswers == MAX_QUIZ_NUMBER_VALUE - 1) {
            scoreRemark = "Congratulations! You correctly answered all questions.";
        } else if (correctAnswers == 0) {
            scoreRemark = "Unfortunately, you did not answer correctly any questions ...";
        } else {
            scoreRemark = "You correctly answered ";
            scoreRemark = scoreRemark.concat(numberOfCorrectAnswers);
            scoreRemark = scoreRemark.concat(" of ");
            scoreRemark = scoreRemark.concat(numberOfQuiz);
            scoreRemark = scoreRemark.concat(" questions.");
        }
        remarkText.setText(scoreRemark);
    }
}
