package com.view.projectapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class Search extends AppCompatActivity {
MaterialSearchView m;
MyDataBase myDataBase;
EditText e;
    String[] datahead;
    String[] datadesc;
    String[] datahead1;
    String[] datadesc1;
ListDetail l;
    java.util.List<StoredData> list;
    java.util.List<String> listdata;
    ArrayList<String> lstf,lstff;
    String headsearch;
public Search(){

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e=findViewById(R.id.headsearch);
    }

    public void search(View view) {
        headsearch=e.getText().toString().trim();
        myDataBase= Room.databaseBuilder(this,MyDataBase.class,"MOVIE_DB").allowMainThreadQueries().build();
        list=new ArrayList<>();
        lstf=new ArrayList<>();
        lstff=new ArrayList<>();
        listdata=new ArrayList<>();
        list=myDataBase.myDao().getAllData();
        if(!headsearch.isEmpty()&& headsearch!=null) {
            int ii=0;
                datahead=new String[30];
                datadesc1=new String[30];
                datahead1=new String[30];
                datadesc=new String[30];
           while (ii<list.size()) {
               datahead[ii] = list.get(ii).getHead_title().toString();
               datadesc[ii] = list.get(ii).getHead_desc().toString();
               ii++;
           }
           for (int i2 = 0; i2 <list.size(); i2++) {
                    if (datahead[i2].matches(headsearch)||datahead[i2].equalsIgnoreCase(headsearch)) {
                        lstf.add(datahead[i2]);
                        lstff.add(datadesc[i2]);
                    }

            }
            Intent i = new Intent(this, SearchList.class);
            i.putStringArrayListExtra("head",lstf);
            i.putStringArrayListExtra("desc",lstff);
            startActivity(i);
        }
        else{
            Toast.makeText(Search.this, "Enter heading to be search", Toast.LENGTH_SHORT).show();
        }
    }

    public void Back(View view) {
        Intent i=new Intent(this,Listdata.class);
        startActivity(i);
    }
}
