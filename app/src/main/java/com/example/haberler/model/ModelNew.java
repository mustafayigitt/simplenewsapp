package com.example.haberler.model;

public class ModelNew {

    private String content;
    private String header;
    private String image;

    public ModelNew(String content, String header, String image) {
        this.content = content;
        this.header = header;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}