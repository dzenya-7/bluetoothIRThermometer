package com.project.dajver.roomdatabaseexample.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.project.dajver.roomdatabaseexample.App;
import com.project.dajver.roomdatabaseexample.Convertation;
import com.project.dajver.roomdatabaseexample.R;
import com.project.dajver.roomdatabaseexample.db.DatabaseHelper;
import com.project.dajver.roomdatabaseexample.db.model.DataModel;
import com.project.dajver.roomdatabaseexample.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;


/**
 * Created by gleb on 11/16/17.
 */

public class GraphActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);
        GraphView graph = findViewById(R.id.graph);
        databaseHelper = App.getInstance().getDatabaseInstance();
        List<DataModel> list = databaseHelper.getDataDao().getAllData();
        double[] arr = Convertation.convert(list);
            DataPoint[] dataPoint = new DataPoint[]{
        };
        for(int i=0;i<arr.length;i++){
            dataPoint = addElement(dataPoint,new DataPoint(i,arr[i]));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoint);
        graph.getViewport().setScalable(true);
        graph.addSeries(series);


    }

    static DataPoint[] addElement(DataPoint[] a, DataPoint e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }


    public void setGraph(){
        /*
        databaseHelper = App.getInstance().getDatabaseInstance();
        List<DataModel> list = databaseHelper.getDataDao().getAllData();
        double[] arr = Convertation.convert(list);
        DataPoint[] dataPoint = new DataPoint[]{

        };
        for(int i=0;i<arr.length;i++){
            dataPoint = addElement(dataPoint,new DataPoint(i,arr[i]));
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoint);

        graph.getViewport().setScalable(true);
        graph.addSeries(series);
        */


    }
}
