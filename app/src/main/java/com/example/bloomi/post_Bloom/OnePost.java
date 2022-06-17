package com.example.bloomi.post_Bloom;

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

    public OnePost(String content) {
        this.content=content;
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
