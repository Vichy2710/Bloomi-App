package com.example.bloomi.Home;

public class OnePost {
    private String content;
    private String image;
    private int likes;

    public OnePost(){}
    public OnePost(String content, String image, int likes) {
        this.content = content;
        this.image = image;
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
