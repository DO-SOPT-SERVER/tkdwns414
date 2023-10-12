package org.example;

public class Main {
    public static void main(String[] args) {
        Poketmon poketmon1 = new Poketmon("모래두지", PoketmonType.GROUND);
        Poketmon poketmon2 = new AquaPoketmon("꼬부기");

        Cat myomyo = new Cat();
        myomyo.울다();
        Dog dog = new Dog();
        dog.울다();
    }
}