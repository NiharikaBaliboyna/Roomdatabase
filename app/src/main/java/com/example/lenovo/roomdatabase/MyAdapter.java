package com.example.lenovo.roomdatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.roomdatabase.roomdatabase.FavoriteMovies;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {
    Context c;
    List<FavoriteMovies> lis;
    public MyAdapter(MainActivity mainActivity, List<FavoriteMovies> lists) {
        this.lis=lists;
        c=mainActivity;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(c).inflate(R.layout.item,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewholder holder, int position) {
        holder.name.setText(lis.get(position).getTitle());
        holder.decr.setText(lis.get(position).getDesc());
        holder.poste.setText(lis.get(position).getPoster());
        holder.rate.setText(String.valueOf(lis.get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return lis.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView name,poste,decr,rate;
        public MyViewholder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            decr=itemView.findViewById(R.id.descr);
            poste=itemView.findViewById(R.id.poste);
            rate=itemView.findViewById(R.id.rati);
        }
    }
}
