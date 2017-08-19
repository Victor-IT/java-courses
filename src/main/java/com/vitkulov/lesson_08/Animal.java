package com.vitkulov.lesson_08;

/**
 * Class describes animal
 */
public class Animal implements Pet {
    private String name;
    private int id;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
