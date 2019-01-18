package com.view.projectapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHold> {
    SearchList searchList;
    ArrayList<String> datahead,datadesc;

    public SearchAdapter(SearchList searchList, ArrayList<String> datahead, ArrayList<String> datadesc) {
        this.searchList=searchList;
        this.datahead=datahead;
        this.datadesc=datadesc;
    }

    @Override
    public SearchAdapter.ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(searchList).inflate(R.layout.raws,parent,false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(SearchAdapter.ViewHold holder, int position) {
        if(datahead.get(position)!=null) {
            holder.textView1.setText(datahead.get(position).toString());
            holder.textView2.setText(datadesc.get(position).toString());
        }
        else {
            holder.textView1.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return datadesc.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {
        TextView textView1,textView2;
        public ViewHold(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.head1);
            textView2=itemView.findViewById(R.id.desc1);
        }
    }
}
