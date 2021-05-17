
package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;
    private TextView textView;
    private Question[] questions = new Question[]{
            new Question(R.string.question0,true),
            new Question(R.string.question1,true),
            new Question(R.string.question2,true),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5, true),
            new Question(R.string.question6, false),
            new Question(R.string.question7, true),
            new Question(R.string.question8, false),
            new Question(R.string.question9, true)
    };
    private String[] answers = {
            "Есть такой вид мух под названием Имаго, которые способны выжить в едкой среде нефти.",
            "Ромашка является символом Дня любви, который отмечается 8 июля.",
            "Это связано с сжатием суставов и рост может уменьшаться на 1-2 см. к вечеру.",
            "Ни одно животное на земле не может выжить в огне.",
            "Это действительно так",
            "Врачами была зафиксирована температура больного 46,5 градусов и после лечения он был выписан здоровым.",
            "Природный газ ничем не пахнет, а запах специально добавляют, чтобы можно было обнаружить утечку.",
            "На рыбалку пошли дедушка, папа и внук.",
            "Коала это сумчатое млекопитающее и к медведям никакого отношения не имеет.",
            "Коттон и хлопок - это один и тот же материал. С английского \"cotton\", \"коттон\" переводится - хлопок."
    };
    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("SYSTEM INFO: ", "Метод onCreate() запущен");

        if(savedInstanceState != null) {
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        yesBtn = findViewById(R.id.btnYes);
        noBtn = findViewById(R.id.btnNo);
        showAnswer = findViewById(R.id.showAnswer);
        textView = findViewById(R.id.textView);
        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();

                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionResId());
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue())
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();

                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionResId());
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                intent.putExtra("answerText", answers[questionIndex]);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d("SYSTEM INFO: ", "Метод onStart() запущен");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("SYSTEM INFO: ", "Метод onResume() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex", questionIndex);
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("SYSTEM INFO: ", "Метод onPause() запущен");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("SYSTEM INFO: ", "Метод onStop() запущен");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Метод onDestroy() запущен");
    }
}