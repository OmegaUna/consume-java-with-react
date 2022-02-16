package domain.model;

import java.time.LocalDate;

public class NewsItem {
    // should have an id according to story2 AddNewsItem
    private String title;
    private String author;
    private String text;
    private String created_at;

    public NewsItem() {
    }

    public NewsItem(String title, String author, String text, String created_at) {
        this.title = title;
        this.author = author;
        this.text = text;
        this.created_at = created_at;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
