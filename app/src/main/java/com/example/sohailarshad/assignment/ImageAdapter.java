package com.example.sohailarshad.assignment;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private List<ImageMetaData> imagesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,date;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            date = (TextView) view.findViewById(R.id.date);
         }
    }


    public ImageAdapter(List<ImageMetaData> moviesList) {
        this.imagesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.imageslistview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageMetaData image = imagesList.get(position);
        holder.name.setText(image.getName());
        holder.date.setText(image.getDate());

    }

    @Override
    public int getItemCount(){
        return imagesList.size();
    }
}