package com.example.contactroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.contactroom.model.Contact;
import com.example.contactroom.model.ContactVIewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    private ContactVIewModel contactVIewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text);

        contactVIewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication())
                .create(ContactVIewModel.class);

        contactVIewModel.getAllContacts().observe(this, (List<Contact> contacts) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Contact contact: contacts) {
                stringBuilder.append("_").append(contact.getName()).append(" ").append(contact.getOccupation());

                Log.d("TAG", "onCreate: " + contact.getName() +" ," + contact.getOccupation());
            }
            textView.setText(stringBuilder.toString());
        });

        FloatingActionButton fab = findViewById(R.id.add_contact_fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, NewContact.class);
            startActivityForResult(intent, NEW_CONTACT_ACTIVITY_REQUEST_CODE);

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_CONTACT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){

            assert data != null;
            String name = data.getStringExtra(NewContact.NAME_REPLY);
            String occu = data.getStringExtra(NewContact.OCCUPATION);

            assert data != null;
            Contact contact = new Contact(name,occu);

            ContactVIewModel.insert(contact);
            Log.d("TAG", "onActivityResult: "+data.getStringExtra(NewContact.NAME_REPLY));
            Log.d("TAG2", "onActivityResult: "+data.getStringExtra(NewContact.OCCUPATION));
        }
    }
}