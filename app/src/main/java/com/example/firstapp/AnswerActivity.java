package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {
    private TextView answerTextView;
    private TextView TextView2;
    private  boolean isAnswerTrue;
    private String textAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        isAnswerTrue = getIntent().getBooleanExtra("answer", false);

        answerTextView = findViewById(R.id.answerTextView);
        answerTextView.setText(isAnswerTrue?R.string.yes:R.string.no);
        /* if(isAnswerTrue) {
            answerTextView.setText(R.string.yes);
        } else {
            answerTextView.setText(R.string.no);
        } */
        textAnswer = getIntent().getStringExtra("answerText");
        TextView2 = findViewById(R.id.textView2);
        TextView2.setText(textAnswer);
    }
}