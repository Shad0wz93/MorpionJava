package com.codingf;

//initialisation de la classe player
public class Player {
    private String name;

    //méthode ppur changer la valeur du nom du player
    public Player(String name){
        setName(name);
    }

    //type paramètre name du player
    public void setName(String name) {

        if(!name.isEmpty()) {
            this.name = name;
        }
    }

    //l'attribut est désigné
    public String getName() {
        return this.name;
    }

}