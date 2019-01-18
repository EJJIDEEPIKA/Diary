package com.view.projectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detaildata extends AppCompatActivity {
TextView tt1,tt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaildata);
        tt1=findViewById(R.id.head11);
        tt2=findViewById(R.id.desc11);
        String hh=getIntent().getStringExtra("hh");
        String dd=getIntent().getStringExtra("dd");
        tt1.setText(hh);
        tt2.setText(dd);
    }

    public void Backl(View view) {
        Intent i=new Intent(this,ListDetail.class);
        startActivity(i);
    }
}
