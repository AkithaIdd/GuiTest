 package com.example.learnjava;

public class Microphone {

   private String name;
    private String color;
    private int model;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public Microphone() {
    }

    public Microphone(String name, String color, int model) {
        this.name = name;
        this.color = color;
        this.model = model;





    }

    public void turnOn() {

        System.out.println(this.name + " Turn On");

    }

    public void turnOff() {

        System.out.println(this.name + " Turn Off");

    }

    public void setVolume() {

      System.out.println(this.name + " Setted volume " + this.model);

    }
}
