package com.example.bio;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.bio.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHobby(v);
            }
        });
//        setContentView(R.layout.activity_main);
//
//        enterHobbys = findViewById(R.id.enterHobby);
//        hobbys = findViewById(R.id.hobby);
    }

    public void addHobby(View view) {

        binding.hobby.setText(String.format("Hobbies%s", binding.enterHobby.getText().toString().trim()));
        binding.hobby.setVisibility(View.VISIBLE);

//        hobbys.setText(String.format("Hobbies%s", enterHobbys.getText().toString().trim()));
//        hobbys.setVisibility(View.VISIBLE);

        //hide keyboard after adding a text

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}