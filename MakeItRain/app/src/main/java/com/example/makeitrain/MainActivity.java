package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView moneyValue;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneyValue = findViewById(R.id.money);

        moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));



    }

    public void showMoney(View view) {

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(moneyCounter)));
         switch (moneyCounter){
             case 20000:
                 moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, android.R.color.holo_orange_dark));
                 break;
             case 30000:
                 moneyValue.setTextColor(Color.MAGENTA);
         }
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this,R.string.app_info,Toast.LENGTH_SHORT)
//                .show();
        Snackbar.make(moneyValue,R.string.app_info, Snackbar.LENGTH_LONG).show();
    }
}