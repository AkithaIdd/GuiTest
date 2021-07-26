package com.example.contactroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactroom.model.Contact;
import com.example.contactroom.model.ContactVIewModel;

public class NewContact extends AppCompatActivity {
    public static final String NAME_REPLY = "name_reply";
    public static final String OCCUPATION = "occupation";
    private TextView enter_name;
    private TextView enter_occu;
    private Button save_btn;
    private ContactVIewModel contactVIewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        enter_name = findViewById(R.id.enterName);
        enter_occu = findViewById(R.id.enterOccu);
        save_btn = findViewById(R.id.saveBtn);

        contactVIewModel = new ViewModelProvider.AndroidViewModelFactory(NewContact.this.getApplication())
                .create(ContactVIewModel.class);

        save_btn.setOnClickListener(v -> {

            Intent replyIntent = new Intent();

            if (!TextUtils.isEmpty(enter_name.getText()) && !TextUtils.isEmpty(enter_occu.getText())){

                String name = enter_name.getText().toString();
                String occupation = enter_occu.getText().toString();

                replyIntent.putExtra(NAME_REPLY, name);
                replyIntent.putExtra(OCCUPATION,occupation);
                setResult(RESULT_OK,replyIntent);





//                ContactVIewModel.insert(contact);


            }else {
                setResult(RESULT_CANCELED,replyIntent);
            }
            finish();
        });
    }
}