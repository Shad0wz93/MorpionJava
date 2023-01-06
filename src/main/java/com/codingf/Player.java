package com.codingf;

public class Player {
    private String name;


    public Player(String name){
        setName(name);
    }

    public void setName(String name) {

        if(!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

}