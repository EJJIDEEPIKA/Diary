package com.view.projectapp;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.view.projectapp.R.layout.deleteraw;

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.HolderData> {
Delete d;
int[] i;
MyDataBase myDataBase;
List<StoredData> l;
int j;
    public DeleteAdapter(Delete delete, List<StoredData> list, MyDataBase myDataBase) {
        d=delete;
        l=list;
        this.myDataBase=myDataBase;
        j=0;
        i=new int[20];
    }
    @Override
    public DeleteAdapter.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(d).inflate(R.layout.deleteraw,parent,false);
        return new HolderData(view);
    }

    @Override
    public void onBindViewHolder(DeleteAdapter.HolderData holder, final int position) {
        holder.tt1.setText(l.get(position).getHead_title());
        holder.tt2.setText(l.get(position).getHead_desc());
        holder.tt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
holder.r.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        d.img.setVisibility(View.VISIBLE);
        myDataBase.myDao().deleteData(l.get(0).getHead_title());
        myDataBase.myDao().updateDate(new StoredData());
        d.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(d, AckDelete.class);
                d.startActivity(i);
            }
        });
    }
});


    }
    @Override
    public int getItemCount() {
        return l.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tt1, tt2;
        RadioButton r;
        public HolderData(View itemView) {
            super(itemView);
            tt1 = itemView.findViewById(R.id.textview1);
            tt2 = itemView.findViewById(R.id.textview2);
            r=itemView.findViewById(R.id.radiobutton);
        }
    }
}