package com.example.csaper6.pokequiz;

public class Pokemon {

    private String name;
    private int weight;

    public Pokemon(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }

}
