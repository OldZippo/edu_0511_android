package com.example.firstapp;

public class Answer {
    private int answerResId; // тут лежит id ответа
    private boolean answerTrue; // какой должен быть ответ

    public Answer(int answerResId, boolean answerTrue) {
        this.answerResId =answerResId;
        this.answerTrue = answerTrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
