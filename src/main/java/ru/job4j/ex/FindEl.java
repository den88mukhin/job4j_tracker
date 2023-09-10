package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNoyFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNoyFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"old", "bread", "car"};
        String key = "Milk";
        try {
            indexOf(value, key);
        } catch (ElementNoyFoundException e) {
            e.printStackTrace();
        }
    }
}
