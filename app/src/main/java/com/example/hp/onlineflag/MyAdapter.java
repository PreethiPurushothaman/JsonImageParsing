package com.example.hp.onlineflag;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    RequestQueue requestQueue;
    StringRequest stringRequest;
    Context context;
    ArrayList<ModelClass> arrayList = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View appearance = inflater.inflate(R.layout.siinglerow,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(appearance);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass modelClass = arrayList.get(position);
        holder.tv1.setText(modelClass.getRank());
        holder.tv2.setText(modelClass.getCountry());
        holder.tv3.setText(modelClass.getPopu());
        Glide.with(context).load(modelClass.getPic()).into(holder.iv);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;
        TextView tv3;
        ImageView iv;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.textView);
            tv2=itemView.findViewById(R.id.textView2);
            tv3=itemView.findViewById(R.id.textView3);
            iv=itemView.findViewById(R.id.imageView);
        }
    }
}
