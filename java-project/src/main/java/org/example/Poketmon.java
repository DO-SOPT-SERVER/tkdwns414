package org.example;

public class Poketmon {
    private String name;
    private PoketmonType type;

    public Poketmon(String name, PoketmonType type) {
        this.name = name;
        this.type = type;
        System.out.println("이름은 " + name);
        System.out.println("타입은 " + type);
    }

}
