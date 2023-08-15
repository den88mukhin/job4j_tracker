package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public double divide(int y) {
        return y / x;
    }

    public double sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        double result = sum(10);
        System.out.println(result);
        result = minus(4);
        System.out.println(result);
        Calculator calculator = new Calculator();
        result = calculator.multiply(2);
        System.out.println(result);
        result = calculator.divide(10);
        System.out.println(result);
        result = calculator.sumAllOperation(10);
        System.out.println(result);
    }
}
