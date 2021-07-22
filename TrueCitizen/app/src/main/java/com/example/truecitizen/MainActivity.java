package com.example.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.truecitizen.databinding.ActivityMainBinding;
import com.example.truecitizen.model.Question;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentIndex = 0;

    private Question[] questionBank = new Question[] {

            new Question(R.string.question_apple, false),
            new Question(R.string.question_copy, true),
            new Question(R.string.question_muddy, false),
            new Question(R.string.question_nut,true),
            new Question(R.string.question_sleep, false)

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.quesTextView.setText(questionBank[currentIndex].getAnswerResId());

        binding.trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });

        binding.falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        binding.nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex +1) % questionBank.length;
                updateQuestion();
                
            }
        });

        binding.preBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentIndex >0){
                    currentIndex = (currentIndex - 1) % questionBank.length;
                    updateQuestion();
                }
            }
        });
    }
    private void checkAnswer(boolean userChooseCorrect){
        boolean answerIsCorrect = questionBank[currentIndex].isAnswerTrue();
        int messageId;

        if (answerIsCorrect == userChooseCorrect){
            messageId =R.string.correct_answer;
        }else {
            messageId = R.string.wrong_answer;
        }

        Snackbar.make(binding.imageView,messageId,Snackbar.LENGTH_SHORT).show();

    }

    private void updateQuestion() {
        binding.quesTextView.setText(questionBank[currentIndex].getAnswerResId());
    }
}