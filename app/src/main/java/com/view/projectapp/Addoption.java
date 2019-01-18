package com.view.projectapp;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Addoption extends AppCompatActivity {
LinearLayout l;
EditText e1,e2;
MyViewModel viewModel;
MyDataBase myDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addoption);
        e1=findViewById(R.id.heading);
        e2=findViewById(R.id.description);
        myDataBase= Room.databaseBuilder(this,MyDataBase.class,"MOVIE_DB").allowMainThreadQueries().build();
    }

    public void Back(View view) {
        Intent i=new Intent(this,Listdata.class);
        startActivity(i);
    }

    public void save(View view) {
    String head=e1.getText().toString().trim();
    String desc=e2.getText().toString().trim();
    if(head.isEmpty()||desc.isEmpty()){
        Toast.makeText(this, "Please enter the data", Toast.LENGTH_SHORT).show();
    }
    else{
        StoredData storedData=new StoredData();
        storedData.setHead_title(head);
        storedData.setHead_desc(desc);
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        myDataBase.myDao().insertData(storedData);
        Intent intent=new Intent(this,Acknowledge.class);
        startActivity(intent);
    }

    }
}
