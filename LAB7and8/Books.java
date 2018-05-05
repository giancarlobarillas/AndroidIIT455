package org.example.lab7and8;

/**
 * Created by GiancarloDesktop on 4/9/2018.
 */

public class Books {
    private int id;
    private  String title;
    private String author;
    private String rating;

    public String getRating() {
        return rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(String rating) {
        this.rating = rating;

    }

    public Books(){

    }
    public Books(String title,String author,String rating){
        super();
        this.title=title;
        this.author=author;
        this.rating=rating;
    }

    public String toString(){
        return "Book id: "+id+" title: "+title+" author: "+author+" rating: "+rating;
    }
}
