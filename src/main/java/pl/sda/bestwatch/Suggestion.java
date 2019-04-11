package pl.sda.bestwatch;

import java.util.ArrayList;

public class Suggestion {
    private String movie;
    private String link;
    private String author;
    private ArrayList<String> authors;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {

        this.movie = movie;
    }

    public String getLink() {
        return link;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
