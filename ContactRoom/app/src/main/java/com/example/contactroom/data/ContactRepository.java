package com.example.contactroom.data;

import android.app.Application;

import com.example.contactroom.model.Contact;
import com.example.contactroom.util.ContactRoomDB;

import java.util.List;

import androidx.lifecycle.LiveData;

public class ContactRepository {
    private ContactDao contactDao;
    private LiveData<List<Contact>> allContacts;

    public ContactRepository(Application application) {

        ContactRoomDB db = ContactRoomDB.getDatabase(application);
        contactDao = db.contactDao();

        allContacts = contactDao.getAllContacts();

    }
    public LiveData<List<Contact>> getAllData(){ return allContacts; }

    public void insert(Contact contact){
        ContactRoomDB.databaseWriteExecutor.execute(()->{
            contactDao.insert(contact);
        });
    }
}
