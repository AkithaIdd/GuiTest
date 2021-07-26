package com.example.sprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.SharedPreferences.*;

public class MainActivity extends AppCompatActivity {

    private static final String MESSAGE_ID = "messages" ;
    private Button saveBtn;
    private EditText enterMsg;
    private TextView showMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveBtn = findViewById(R.id.button);
        enterMsg = findViewById(R.id.editText);
        showMsg = findViewById(R.id.textView);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = enterMsg.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("message",message);

                editor.apply();//saving to disk
            }
        });

        //get data back

        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
       String value = getShareData.getString("message","nothing yet");

       showMsg.setText(value);
    }
}