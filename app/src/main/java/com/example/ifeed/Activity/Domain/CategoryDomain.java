package com.example.ifeed.Activity.Domain;

public class CategoryDomain {
    private String title;
    private String pic;

    public CategoryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }

    public String getTitle() {
        return this.title; //diferente aqui
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return this.pic; //diferente aqui
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


}
