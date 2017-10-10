package com.example.sohailarshad.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Book> books = new ArrayList<>();
    private RecyclerView recyclerView;
    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        int min = 1;
        int max = 10;
        Random rand = new Random();
        for(int i=0;i<10;i++){
            Book book = new Book();
            book.setName("Book " + (i+1));
            book.setRating(rand.nextInt(max - min + 1) + min);
            books.add(book);
        }

        books.get(0).setUrl("https://i.ebayimg.com/images/g/l6IAAOxyUrZS64di/s-l300.jpg");
        books.get(1).setUrl("http://www.startupremarkable.com/wp-content/uploads/2015/02/a-book-a-week-image.jpg");
        books.get(2).setUrl("https://af-production.s3.amazonaws.com/photos/images/76458/original/books.jpg");
        books.get(3).setUrl("http://whytoread.com/wp-content/uploads/2015/03/best-books-book-youll-ever-read.jpg");
        books.get(4).setUrl("http://images.clipartpanda.com/book-20clip-20art-dT6LxAaT9.jpeg");
        books.get(5).setUrl("http://www.library.lapeer.org/children/images/books.jpeg/@@images/image.jpeg");
        books.get(6).setUrl("https://www.thechildrensbookreview.com/wp-content/uploads/2016/08/books-that-matter-book-review.png");
        books.get(7).setUrl("http://whytoread.com/wp-content/uploads/2015/03/8-Books-That-Will-Leave-You-Feeling-Amazing-And-On-Top-Of-The-World.jpg");
        books.get(8).setUrl("http://pngimg.com/uploads/book/book_PNG2116.png");
        books.get(9).setUrl("https://modernmrsdarcy.com/wp-content/uploads/2017/02/books-journal-coffee-horizontal.jpg");

        mAdapter = new BookAdapter(books);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(mAdapter);
    }

}
