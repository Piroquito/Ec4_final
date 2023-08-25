package com.edder.ec4_edder.data.db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.edder.ec4_edder.model.ShowEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ShowEntity.class},version = 1)
public abstract class Ec4Database extends RoomDatabase {

    public abstract ShowDao showDao();

    private static volatile Ec4Database db;

    public static final ExecutorService dataBaseWriteExecuter = Executors.newFixedThreadPool(4);

    public static Ec4Database getInstance(Context context){
        Ec4Database dbTemp = db;
        if(db == null){
            synchronized (Ec4Database.class){
                if(db == null){
                    db = Room.databaseBuilder(context.getApplicationContext(), Ec4Database.class,"shows-database").build();
                }
            }

        }
        return db;
    }
}
