package com.example.trivia.Util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    public static final String STATE = "trivia state";
    private SharedPreferences sharedPreferences ;
    public static final String HIGHEST_SCORE = "highest_score";

    public Prefs(Activity context) {
        this.sharedPreferences = context.getPreferences(Context.MODE_PRIVATE);
    }

    public void saveHighestScore(int score){

        int lastScore = sharedPreferences.getInt(HIGHEST_SCORE,0);

        if (score > lastScore){
            sharedPreferences.edit().putInt(HIGHEST_SCORE, score).apply();
        }

    }

    public int getHighestScore(){
        return sharedPreferences.getInt(HIGHEST_SCORE,0);
    }

    public void setState(int index){
        sharedPreferences.edit().putInt(STATE, index).apply();
    }

    public int getState() {
        return sharedPreferences.getInt(STATE,0);
    }
}
