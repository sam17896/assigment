package com.example.sohailarshad.assignment;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private List<ImageMetaData> imagesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, rate;
        public ImageView img;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            rate = (TextView) view.findViewById(R.id.rating);
            img = (ImageView) view.findViewById(R.id.img);
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
        holder.rate.setText(String.valueOf(image.getRating()));
        Glide.with(holder.img.getContext()).load("http://www.startupremarkable.com/wp-content/uploads/2015/02/a-book-a-week-image.jpg").into(holder.img);
        //Glide.with(holder.img.getContext()).load(image.getLocation()).into(holder.img);
    }

    @Override
    public int getItemCount(){
        return imagesList.size();
    }
}