package com.example.firstapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private String[] textResult = new String[10];
    private TextView textResult0, textResult1, textResult2, textResult3, textResult4,
                     textResult5, textResult6, textResult7, textResult8, textResult9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textResult = getIntent().getStringArrayExtra("answer_Text");
        //
       /* if (textResult[0] != "Правильно!") {
            color = Color.GREEN;
        }else {
            color = Color.RED;
        }*/
        textResult0 = findViewById(R.id.textResult0);
        textResult0.setText(textResult[0]);
        ColorizeResult(textResult0);
        //
        textResult1 = findViewById(R.id.textResult1);
        textResult1.setText(textResult[1]);
        ColorizeResult(textResult1);
        //
        textResult2 = findViewById(R.id.textResult2);
        textResult2.setText(textResult[2]);
        ColorizeResult(textResult2);
        //
        textResult3 = findViewById(R.id.textResult3);
        textResult3.setText(textResult[3]);
        ColorizeResult(textResult3);
        //
        textResult4 = findViewById(R.id.textResult4);
        textResult4.setText(textResult[4]);
        ColorizeResult(textResult4);
        //
        textResult5 = findViewById(R.id.textResult5);
        textResult5.setText(textResult[5]);
        ColorizeResult(textResult5);
        //
        textResult6 = findViewById(R.id.textResult6);
        textResult6.setText(textResult[6]);
        ColorizeResult(textResult6);
        //
        textResult7 = findViewById(R.id.textResult7);
        textResult7.setText(textResult[7]);
        ColorizeResult(textResult7);
        //
        textResult8 = findViewById(R.id.textResult8);
        textResult8.setText(textResult[8]);
        ColorizeResult(textResult8);
        //
        textResult9 = findViewById(R.id.textResult9);
        textResult9.setText(textResult[9]);
        ColorizeResult(textResult9);
    }
    void ColorizeResult(TextView textResult) {
        String text;
        int color=-1;

        text = textResult.getText().toString();
        if ((text).equals("Правильно!")) {
            color = Color.GREEN;
        } else {
            color = Color.RED;
        }
        textResult.setTextColor(color);
    };
}