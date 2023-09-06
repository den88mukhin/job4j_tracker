package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Летит по воздуху");
    }

    @Override
    public void passengers() {
        System.out.println("100 пассажиров");
    }
}
