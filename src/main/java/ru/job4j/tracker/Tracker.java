package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findByAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizeNew = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                rsl[i] = item;
                sizeNew++;
            }
        }
        return Arrays.copyOf(rsl, sizeNew);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : items[index];
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean isValid = index != -1;
        if (isValid) {
            item.setId(id);
            items[index] = item;
        }
        return isValid;
    }
}