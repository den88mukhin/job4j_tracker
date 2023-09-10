package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Едит по рельсам");
    }

    @Override
    public void passengers() {
        System.out.println("300 пассажиров");
    }
}
