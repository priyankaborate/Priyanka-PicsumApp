package com.zinftech.priyaspicsumapp.model;

public class AuthorModel
{
    private int id;
    private String author;

    public AuthorModel(int id,String author)
    {
        this.id = id;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
