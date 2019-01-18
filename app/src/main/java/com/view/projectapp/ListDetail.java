package com.view.projectapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListDetail extends AppCompatActivity {
    MyDataBase myDataBase;
    MyViewModel viewModel;
    MyAdapter myAdapter;
    RecyclerView rc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail);
        rc=findViewById(R.id.rc);
        myDataBase= Room.databaseBuilder(this,MyDataBase.class,"MOVIE_DB").allowMainThreadQueries().build();
        viewModel= ViewModelProviders.of(this).get(MyViewModel.class);
      java.util.List<StoredData> list=new ArrayList<>();
        list= myDataBase.myDao().getAllData();
        viewModel.setList((java.util.List<StoredData>) list);
        Observer<java.util.List<StoredData>> observer=new Observer<java.util.List<StoredData>>() {
            @Override
            public void onChanged(@Nullable java.util.List<StoredData> storedData) {
                myAdapter=new MyAdapter(ListDetail.this,storedData);
                rc.setAdapter(myAdapter);
            }
        };
        viewModel.getList().observe(this,observer);
       rc.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rc.setLayoutManager(new LinearLayoutManager(this));
    }
    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getList().setValue(myDataBase.myDao().getAllData());
    }


    public void Back1(View view) {
        Intent i=new Intent(this,Listdata.class);
        startActivity(i);
    }
}
