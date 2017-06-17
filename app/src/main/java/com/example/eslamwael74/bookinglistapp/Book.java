package com.example.eslamwael74.bookinglistapp;

import java.util.ArrayList;

/**
 * Created by Eslam Wael on 6/15/2017.
 */

public class Book {

    String image;
    String tittle;
    String subTittle;
    String Author;
    String publishDate;

    public Book(String image, String tittle, String subTittle, String author, String publishDate) {
        this.image = image;
        this.tittle = tittle;
        this.subTittle = subTittle;
        Author = author;
        this.publishDate = publishDate;
    }

    public Book() {

    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSubTittle() {
        return subTittle;
    }

    public void setSubTittle(String subTittle) {
        this.subTittle = subTittle;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
