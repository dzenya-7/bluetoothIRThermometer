package com.project.dajver.roomdatabaseexample.db;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.project.dajver.roomdatabaseexample.db.model.DataModel;

/**
 * Created by gleb on 11/16/17.
 */

@Database(entities = { DataModel.class }, version = 1, exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {

    public abstract DataDao getDataDao();

}