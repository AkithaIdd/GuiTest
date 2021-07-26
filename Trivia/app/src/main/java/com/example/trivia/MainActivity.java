package com.example.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.trivia.Util.Prefs;
import com.example.trivia.data.Repository;
import com.example.trivia.databinding.ActivityMainBinding;
import com.example.trivia.model.Question;
import com.example.trivia.model.Score;
import com.google.android.material.snackbar.Snackbar;

import java.text.MessageFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private ActivityMainBinding binding;
    private int currentQuestionIndex = 0;
    List<Question>  questionList;
    private int scoreCounter = 0;
    private Score score;
    private Prefs prefs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        score = new Score();
        prefs = new Prefs(MainActivity.this);
        currentQuestionIndex = prefs.getState();

        binding.HighScroeTime.setText(String.valueOf(prefs.getHighestScore()));



         questionList =  new Repository().getQuestions(questionArrayList -> {
                     binding.questionText.setText(questionArrayList.get(currentQuestionIndex).getAnswer());

                     updateCounter(questionList);
                 }
               );

         binding.buttonNext.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 getNext();


             }
         });

         binding.buttonTure.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 checkAnswer(true);
                 updateQuestion();

             }
         });

         binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 checkAnswer(false);
                 updateQuestion();

             }
         });


    }

    private void getNext() {
        currentQuestionIndex = (currentQuestionIndex +1 ) % questionList.size();
        updateQuestion();
    }

    private void checkAnswer(boolean userChooseCorrect) {
        boolean answer = questionList.get(currentQuestionIndex).isAnswerTrue();
        int snackMessageId = 0;
        if (userChooseCorrect == answer){
            snackMessageId = R.string.correct_answer;
            fadeAnim();
            addPoints();
        }else{
            snackMessageId = R.string.Wrong_answer;
            shakeAnim();
            deductPoint();
        }
        Snackbar.make(binding.cardView,snackMessageId,Snackbar.LENGTH_SHORT).show();

    }

    private void updateCounter(List<Question> questionList) {
        binding.outOfText.setText("Question: " + (currentQuestionIndex+1)+"/"+ this.questionList.size());
    }

    private void updateQuestion() {
        String question = questionList.get(currentQuestionIndex).getAnswer();
        binding.questionText.setText(question);
        updateCounter(questionList);
    }

    private void fadeAnim(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,1.1f);
        alphaAnimation.setDuration(300);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.REVERSE);

        binding.cardView.setAnimation(alphaAnimation);

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.questionText.setTextColor(Color.GREEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.questionText.setTextColor(Color.WHITE);

                getNext();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void shakeAnim(){
        Animation shake = AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake_anim);
        binding.cardView.setAnimation(shake);

        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.questionText.setTextColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.questionText.setTextColor(Color.WHITE);
                getNext();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

     private void addPoints(){
        scoreCounter += 100;
        score.setScroe(scoreCounter);
         binding.highScroe.setText(String.valueOf(score.getScroe()));
//         binding.highScroe.setText(MessageFormat.format("Current Score: {0}",
//                 String.valueOf(score.getScroe())));
     }
     private void deductPoint(){

        if (scoreCounter > 0){
            scoreCounter -= 100;
            score.setScroe(scoreCounter);
            binding.highScroe.setText(String.valueOf(score.getScroe()));
        }else {
            scoreCounter = 0;
            score.setScroe(scoreCounter);
        }


     }

    @Override
    protected void onPause() {
        prefs.saveHighestScore(score.getScroe());
        prefs.setState(currentQuestionIndex);
        super.onPause();
    }
}