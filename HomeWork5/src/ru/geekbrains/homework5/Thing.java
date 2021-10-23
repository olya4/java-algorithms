package ru.geekbrains.homework5;

public class Thing {
    private String title;
    private int weight;
    private int cost;

    public Thing(String title, int weight, int cost) {
        this.title = title;
        this.weight = weight;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }
}
