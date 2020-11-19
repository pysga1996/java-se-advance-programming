package com.tutorial;

public class Dog extends Animal implements CryAble {
    public static final String CRY = "Gau gau";
    public static final int NUMBER_OF_LEGS = 4;

    // Private field.
    private String name;

    // Private field
    public int age;

    public Dog() {

    }

    public Dog(String name) {
        this.name = name;
        this.age = 1;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    // Private Method.
    private void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Implements from interface CryAble.
     */
    @Override
    public String cry() {
        return CRY;
    }

    /**
     * Implements from Animal.
     */
    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }
}
