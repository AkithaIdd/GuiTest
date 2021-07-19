package com.example.guifirsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button showBtn;
    private TextView nameText;
    private TextView editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBtn = findViewById(R.id.button);
        nameText = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String name = editText.getText().toString();
                 if (name.isEmpty()){
                     nameText.setText("");
                 }else {
                     nameText.setText("Hello " + name);
                 }

            }
        });


    }
}