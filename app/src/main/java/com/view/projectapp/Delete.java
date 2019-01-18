package com.view.projectapp;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.net.sip.SipSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Delete extends AppCompatActivity {
    RecyclerView l;
    StoredData sd;
    MyDataBase myDataBase;
    java.util.List<StoredData> list;
    DeleteAdapter adapter;
    ImageButton img;
    MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        l = findViewById(R.id.listview);
        myDataBase = Room.databaseBuilder(this, MyDataBase.class, "MOVIE_DB").allowMainThreadQueries().build();
        list = new ArrayList<>();
        img = findViewById(R.id.delete);
        sd = new StoredData();

        list = myDataBase.myDao().getAllData();
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        adapter = new DeleteAdapter(this, list, myDataBase);
        l.setLayoutManager(new LinearLayoutManager(this));
        l.setAdapter(adapter);
    }

    public void BackDelete(View view) {
        Intent i = new Intent(this, Listdata.class);
        startActivity(i);
    }





}
