package com.example.eslamwael74.bookinglistapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Eslam Wael on 6/16/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CustomViewHolder> {

    ArrayList<Book> books;
    Context context;

    public RecyclerViewAdapter(Context context,ArrayList<Book> books) {
        this.books = books;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Book book = books.get(i);

        Picasso.with(context).
                load(book.getImage()).
                into(customViewHolder.imageView);

        customViewHolder.tTittle.setText(book.getTittle());
        customViewHolder.tSubTitle.setText(book.getSubTittle());
        customViewHolder.tAuthors.setText(book.getAuthor());
        customViewHolder.tPublishDate.setText(book.getPublishDate());
    }

    @Override
    public int getItemCount() {
        return (null != books ? books.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tTittle;
        TextView tSubTitle;
        TextView tAuthors;
        TextView tPublishDate;

        public CustomViewHolder(View view) {

            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.smallThumbnail);
            this.tTittle = (TextView) view.findViewById(R.id.title_card);
            this.tSubTitle = (TextView) view.findViewById(R.id.subtitle_card);
            this.tAuthors = (TextView) view.findViewById(R.id.authors_card);
            this.tPublishDate = (TextView) view.findViewById(R.id.publishedDate_card);
        }
    }

}
