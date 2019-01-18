package com.view.projectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.text1);
        t2=findViewById(R.id.text2);
        t3=findViewById(R.id.text3);
        t1.setText("bluDiary");
        t2.setText("Welcome to bluDiary");
        t3.setText("Your personal diary app.");

    }

    public void Enter(View view) {
        Intent i=new Intent(this,Login.class);
        startActivity(i);
    }



}
