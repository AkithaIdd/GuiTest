package com.example.inheritance;

public class Hero extends Person{

    int power;

    public Hero(String name, int age, int power) {
        super(name, age);
        this.power = power;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + 1000;
    }

    @Override
    public String getName() {
        return super.getName() + " idda";
    }

    @Override
    public String toString() {
        return this.getSalary() + this.getName();
    }
}
