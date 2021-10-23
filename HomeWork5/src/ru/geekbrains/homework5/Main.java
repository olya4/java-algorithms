package ru.geekbrains.homework5;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Backpack backpack = new Backpack(10);

        List<Thing> things = new ArrayList<>();

        Thing thing1 = new Thing("Книга", 3, 100);
        Thing thing2 = new Thing("Блокнот", 2, 20);
        Thing thing3 = new Thing("Бутылка с водой", 4, 10);
        Thing thing4 = new Thing("Печенье", 2, 40);
        Thing thing5 = new Thing("Ноутбук", 5, 1000);

        things.add(thing1);
        things.add(thing2);
        things.add(thing3);
        things.add(thing4);
        things.add(thing5);

        backpack.addThingsInBackpack(things);

        backpack.showBackpacks();

    }
}
