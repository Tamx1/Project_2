package com.example.Test1.Cars;

public class Car {
    private int id;
    private String model;
    private String yearOfMake;
    private String color;
    private double price;

    public Car() {
    }

    public Car(int id, String model, String yearOfMake, String color, double price) {
        this.id = id;
        this.model = model;
        this.yearOfMake = yearOfMake;
        this.color = color;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(String yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}