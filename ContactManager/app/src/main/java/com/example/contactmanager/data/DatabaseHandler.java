package com.example.contactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.contactmanager.R;
import com.example.contactmanager.model.Contact;
import com.example.contactmanager.util.Util;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

         String CREATE_CONTACT_TABLE = " CREATE TABLE " + Util.DATABASE_TABLE + " ( " + Util.KEY_ID + " INTEGER PRIMARY KEY , "
                 + Util.KEY_NAME + " TEXT," + Util.KEY_PHONE_NUMBER + " TEXT " + ")";

         sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //DROP A EXSISTING TABLE

        String DROP_TABLE = String.valueOf(R.string.db_drop);
        sqLiteDatabase.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});

        //CREATE A TABLE AGAIN

        onCreate(sqLiteDatabase);

    }

    //CRUD

    //Creat

    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME,contact.getName());
        values.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNum());

        db.insert(Util.DATABASE_TABLE,null,values); //insert to raw
        db.close(); // close db connection

    }

    //Read

    public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.DATABASE_TABLE, new String[]{Util.KEY_ID,Util.KEY_NAME,Util.KEY_PHONE_NUMBER},
                Util.KEY_ID +"=?",new String[]{String.valueOf(id)},null,null,null);

        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhoneNum(cursor.getString(2));

        return contact;
    }

    //get all contacts

    public List<Contact> getAllContacts(){
        List<Contact> contactslist = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = "SELECT * FROM " + Util.DATABASE_TABLE;
        Cursor cursor = db.rawQuery(selectAll, null);

        //Loop through our data

        if (cursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNum(cursor.getString(2));

                // add contacts objects to our list

                contactslist.add(contact);
            }while (cursor.moveToNext());
        }
        return contactslist;


    }

    //Update contact

    public int updateContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNum());

        //update raw

        return db.update(Util.DATABASE_TABLE,values,Util.KEY_ID + "=?",new String[]{String.valueOf(contact.getId())});
    }

    //Delete a contact

    public void deleteContact(Contact contact){

        SQLiteDatabase db =this.getWritableDatabase();

        db.delete(Util.DATABASE_TABLE,Util.KEY_ID +"=?",new String[]{String.valueOf(contact.getId())});

        db.close();

    }

    public int getCount(){
        String countQuery = " SELECT * FROM " + Util.DATABASE_TABLE ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);

        return cursor.getCount();
    }





}
