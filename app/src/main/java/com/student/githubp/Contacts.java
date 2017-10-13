package com.student.githubp;

public class Contacts {
    private String name,img;

    public Contacts(String img, String name){
        this.setName(name);

       this.setimg(img);
    }
    public String getimg() {
        return img;
    }

    public void setimg(String img) {
        this.img = img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
