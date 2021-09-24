package com.project.dajver.roomdatabaseexample.db.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by gleb on 11/15/17.
 */

@Entity(primaryKeys = {"name","temperature"})
public class DataModel {

    public double temperature;
    @NonNull public String name;
    public String lastName;
    public String dadName;
    public String date;

    public DataModel(double temperature, String name, String lastName, String dadName, String date) {
        this.temperature = temperature;
        this.name = name;
        this.lastName = lastName;
        this.dadName = dadName;
        this.date = date;
    }
}
