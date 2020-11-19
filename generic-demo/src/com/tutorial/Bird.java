package com.tutorial;

public class Bird extends Animal {
    public String name;

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    public void move() {
        System.out.println(name + " is flying");
    }
}
