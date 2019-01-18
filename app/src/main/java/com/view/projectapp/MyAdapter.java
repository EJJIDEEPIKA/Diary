package com.view.projectapp;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>{
    List<StoredData> storedData;
    ListDetail listDetail;


    public MyAdapter(ListDetail listDetail, List<StoredData> storedData) {
        this.storedData=storedData;
        this.listDetail=listDetail;

    }


    @Override
    public MyAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(listDetail).inflate(R.layout.raw,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.Holder holder, final int position) {
        holder.t1.setText(storedData.get(position).getHead_title());
        holder.t2.setText(storedData.get(position).getHead_desc());
        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(listDetail,Detaildata.class);
                i.putExtra("hh",storedData.get(position).getHead_title());
                i.putExtra("dd",storedData.get(position).getHead_desc());
                listDetail.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storedData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public Holder(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.head);
            t2=itemView.findViewById(R.id.desc);
        }
    }
}
