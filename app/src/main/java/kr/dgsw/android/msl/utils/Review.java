package kr.dgsw.android.msl.utils;

import java.io.Serializable;

public class Review implements Serializable {

    String context;
    String img;
    String menu;
    String name;
    String owner;
    long star;

    public Review() { }

    public Review(String context, String img, String menu, String name, String owner, long star) {
        this.context = context;
        this.img = img;
        this.menu = menu;
        this.name = name;
        this.owner = owner;
        this.star = star;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getStar() {
        return star;
    }

    public void setStar(long star) {
        this.star = star;
    }
}