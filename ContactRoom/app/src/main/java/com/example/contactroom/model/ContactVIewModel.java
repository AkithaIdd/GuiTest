package com.example.contactroom.model;

import android.app.Application;

import com.example.contactroom.data.ContactRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ContactVIewModel extends AndroidViewModel {
    
    public static ContactRepository repository;
    public final LiveData<List<Contact>> allContacts;


    public ContactVIewModel(@NonNull Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllData();
    }

    public LiveData<List<Contact>> getAllContacts() {return allContacts;}

    public static void insert(Contact contact) {repository.insert(contact);}
}
