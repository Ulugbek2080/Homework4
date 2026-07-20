package org.example;

public class Player {
    private int id;
    private String name;
    private int strength;

    public int getId() {
        return id;
    }

    public void setTitle(String name){
        this.name = name;
    }

    public String getTitle() {
        return name;
    }

    public void setPrice(int strength){
        this.strength = strength;
    }

    public int getPrice() {
        return strength;
    }
}
