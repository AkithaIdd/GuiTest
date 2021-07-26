package com.example.contactroom.data;

import com.example.contactroom.model.Contact;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ContactDao {

    //CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Contact contact);


    @Query("DELETE FROM contact_table")
    void deteleAll();

    @Query("SELECT * FROM contact_table ORDER BY name ASC")
    LiveData<List<Contact>> getAllContacts();
}
