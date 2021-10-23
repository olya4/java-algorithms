package ru.geekbrains.homework5;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private int max_weight;

    private List<Thing> backpacks = null;

    public Backpack(int max_weight) {
        this.max_weight = max_weight;
    }

    // всего по весу
    public int sumWeight(List<Thing> things) {
        int sumWeight = 0;
        for (Thing thing : things) {
            sumWeight += thing.getWeight();
        }
        return sumWeight;
    }


    // положить в рюкзак
    public void putThing(List<Thing> things) {
        // суммарный вес вещей
        int weightBackpack = sumWeight(things);
//      если вещь проходит по весу
        if (weightBackpack <= max_weight) {
//           список содержимого рюкзака = списку положенных вещей
            backpacks = things;
        }
    }

    // вещи, которые хотят положить в рюкзак
    public void addThingsInBackpack(List<Thing> things) {
        if (things.isEmpty()) {
            return;
        }
        // положить вещи в рюкзак
        putThing(things);

        // перебрать список вещей
        for (int i = 0; i < things.size(); i++) {
            // копия списка вещей
            List<Thing> copies = new ArrayList<>(things);
            // очистить скопированный список
            copies.remove(i);
            // вещи, которые хотят положить в рюкзак
            addThingsInBackpack(copies);
        }
    }

    // получить содержимое рюкзака
    public List<Thing> getBackpacks() {
        return backpacks;
    }

    public void showBackpacks() {
        System.out.println("В рюкзаке находятся:");
        for (Thing thing : getBackpacks()) {
            System.out.println(thing.getTitle() + " " + thing.getWeight() + " " + thing.getCost());
        }
    }

}
