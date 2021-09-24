package com.project.dajver.roomdatabaseexample;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.project.dajver.roomdatabaseexample.db.DatabaseHelper;

/**
 * Created by gleb on 11/16/17.
 */

public class App extends Application {

    private static App instance;
    private DatabaseHelper db;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, "data-database")
                .allowMainThreadQueries()
                .build();
    }

    public DatabaseHelper getDatabaseInstance() {
        return db;
    }
}
