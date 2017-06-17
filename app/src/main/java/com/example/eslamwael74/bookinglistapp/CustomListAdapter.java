package com.example.eslamwael74.bookinglistapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eslam Wael on 6/15/2017.
 */

public class CustomListAdapter extends ArrayAdapter<Book> {

    ArrayList<Book> books;
    Context context;
    int resource;


    public CustomListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Book> books) {

        super(context, resource, books);
        this.books = books;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Book book = getItem(position);

        if(convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_layout,null, true);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewBook);
        Picasso.with(context).
                load(book.getImage()).
                into(imageView);

        if(book.getTittle().length()>=25)
        {
            book.setTittle(book.getTittle().substring(0,25));
        }

        TextView tittle = (TextView) convertView.findViewById(R.id.tittle);
        tittle.setText(book.getTittle());

        TextView subTittle = (TextView) convertView.findViewById(R.id.subtitle);
        subTittle.setText(book.getSubTittle());

        TextView authors = (TextView) convertView.findViewById(R.id.authors);
        authors.setText(book.getAuthor());

        TextView publishedDate = (TextView) convertView.findViewById(R.id.publishedDate);
        publishedDate.setText(book.getPublishDate());

        return convertView;

    }
}
