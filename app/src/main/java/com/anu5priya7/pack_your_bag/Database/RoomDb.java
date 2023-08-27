package com.anu5priya7.pack_your_bag.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.anu5priya7.pack_your_bag.Dao.ItemsDao;
import com.anu5priya7.pack_your_bag.Models.Items;

@Database(entities = Items.class, version = 1, exportSchema = false)
 public abstract class RoomDb extends RoomDatabase {

    private static RoomDb database;
    private static String DATABASE_NAME = "MyDb";

    public synchronized static RoomDb getInstance(Context context){
        if(database == null){
            database= Room.databaseBuilder(context.getApplicationContext(),
                    RoomDb.class, DATABASE_NAME).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }

    public abstract ItemsDao mainDao();




}
