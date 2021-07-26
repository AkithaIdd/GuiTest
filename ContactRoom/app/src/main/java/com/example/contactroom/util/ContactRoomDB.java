package com.example.contactroom.util;

import android.content.Context;

import com.example.contactroom.data.ContactDao;
import com.example.contactroom.model.Contact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Contact.class}, version = 1,exportSchema = false)
public abstract class ContactRoomDB extends RoomDatabase {

    public abstract ContactDao contactDao();
    public static final int NUMBER_OF_THREADS = 4;

    private static volatile ContactRoomDB INSTANCE;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ContactRoomDB getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (ContactRoomDB.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),ContactRoomDB.class,"contact_db")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(()->{
                ContactDao contactDao = INSTANCE.contactDao();
                contactDao.deteleAll();

                Contact contact = new Contact("akitha", "student");
                contactDao.insert(contact);

                contact = new Contact("bond","spy");
                contactDao.insert(contact);

            });
        }
    };


}
