package com.project.dajver.roomdatabaseexample;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.dajver.roomdatabaseexample.db.DatabaseHelper;
import com.project.dajver.roomdatabaseexample.db.model.DataModel;
import com.project.dajver.roomdatabaseexample.ui.GraphActivity;
import com.project.dajver.roomdatabaseexample.ui.main.adapter.SomeDataRecyclerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DBActivity extends AppCompatActivity implements SomeDataRecyclerAdapter.OnDeleteListener {


    RecyclerView recyclerView;

    public DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        recyclerView = findViewById(R.id.recyclerView);
        databaseHelper = App.getInstance().getDatabaseInstance();
            final LinearLayoutManager layoutManager = new LinearLayoutManager(DBActivity.this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
            List<DataModel> dataModels = databaseHelper.getDataDao().getAllData();
            SomeDataRecyclerAdapter recyclerAdapter = new SomeDataRecyclerAdapter(this,dataModels );
            recyclerAdapter.setOnDeleteListener(this);
            recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onDelete(DataModel dataModel) {
        databaseHelper.getDataDao().delete(dataModel);
    }

}