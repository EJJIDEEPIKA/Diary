package com.view.projectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class SearchList extends AppCompatActivity {
RecyclerView rc1;
SearchAdapter adapter1;
ArrayList<String> datahead,datadesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
       datahead=getIntent().getStringArrayListExtra("head");
        datadesc=getIntent().getStringArrayListExtra("desc");
        rc1=findViewById(R.id.rc1);
        rc1.setLayoutManager(new LinearLayoutManager(this));
        adapter1=new SearchAdapter(SearchList.this,datahead,datadesc);
        rc1.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rc1.setAdapter(adapter1);

    }

    public void Backsearch(View view) {
        Intent i=new Intent(this,Search.class);
        startActivity(i);
    }
}
