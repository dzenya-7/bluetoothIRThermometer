package com.project.dajver.roomdatabaseexample;

import com.project.dajver.roomdatabaseexample.db.model.DataModel;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Convertation {
    public static double[] convert(List<DataModel> dataModels){
        double[] arr = new double[1000];
        int i=0;
        for (DataModel dataModel:dataModels) {
            arr[i]=dataModel.temperature;
            i++;
        }
        return Arrays.copyOf(arr,i);
    }
}
