 package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.data.DatabaseHandler;
import com.example.contactmanager.model.Contact;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        //get count

        Log.d("count", "onCreate: " +db.getCount());


        //create contacts objects

        Contact akitha = new Contact();
        Contact saman = new Contact();

        akitha.setName("Akitha");
        akitha.setPhoneNum("123445");

        saman.setName("Saman");
        saman.setPhoneNum("98765");

        db.addContact(akitha);
        db.addContact(saman);
        Log.d("add", "onCreate: added");
        //delete a contact
//
//        Contact contact2 = db.getContact(3);
//        db.deleteContact(contact2);

        //get all

        List<Contact> contactList = db.getAllContacts();

        for (Contact contact: contactList) {
            Log.d("Main", "onCreate: " + contact.getId());





        }
        //get 1 contact

//       Contact contact = db.getContact(2);
//
//       Log.d("TAG", "onCreate: " + contact.getName() + " ," + contact.getPhoneNum());

       //update raw

//        Contact contact1 = db.getContact(3);
//        contact1.setName("idd");
//        contact1.setPhoneNum("55555");
//
//        int updated = db.updateContact(contact1);
//        Log.d("updated", "onCreate: " + updated);




    }
}