package com.view.projectapp;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class AckDelete extends AppCompatActivity {
String h,d;
int h1;

ViewModel viewModel;
    String[] datahead;
    String[] datadesc;
    MyDataBase myDataBase;
    java.util.List<StoredData> list;

    public AckDelete(View.OnClickListener onClickListener, String h, String d) {
        this.h=h;
        this.d=d;
    }
public AckDelete(){

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ack_delete);
        h1=getIntent().getIntExtra("posi",1);
//        d=getIntent().getStringExtra("description");
        list=new ArrayList<>();
        Toast.makeText(this, ""+h1, Toast.LENGTH_SHORT).show();
        myDataBase= Room.databaseBuilder(this,MyDataBase.class,"MOVIE_DB").allowMainThreadQueries().build();
        list=myDataBase.myDao().getAllData();
        int ii=0;
        datahead=new String[30];
        datadesc=new String[30];
        Toast.makeText(this, ""+list.size(), Toast.LENGTH_SHORT).show();
       /*while ( ii<list.size()) {
            datahead[ii] = list.get(ii).getHead_title().toString();
            datadesc[ii] = list.get(ii).getHead_desc().toString();
            ii++;
        }
     for (int i2 = 0; i2 <list.size(); i2++) {
            if (datahead[i2].matches(h)||datahead[i2].equalsIgnoreCase(h)) {
              list.remove(i2);
            }

        }*/
    }

    public void Backd(View view) {
        Intent i=new Intent(this,Delete.class);
        startActivity(i);
    }
}
