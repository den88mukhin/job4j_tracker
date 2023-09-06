package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едит по шоссе");
    }

    @Override
    public void passengers() {
        System.out.println("40 пассажиров");
    }
}
