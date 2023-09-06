package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Ехать");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Колличество пассажиров: " + passengers);
    }

    @Override
    public int refill(int fuel) {
        return fuel * 30;
    }
}
