package com.example.sohailarshad.assignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private List<Book> books;

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


    public BookAdapter(List<Book> moviesList) {
        this.books = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booklistview, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book book = books.get(position);
        holder.name.setText(book.getName());
        holder.rate.setText(String.valueOf(book.getRating()));
        Glide.with(holder.img.getContext()).load(book.getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount(){
        return books.size();
    }
}