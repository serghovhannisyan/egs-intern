package com.egs.serg.task4;

import java.util.Iterator;
import java.util.Map;

public class MyHashMap {

    private Entry[] arr = new Entry[16];
    private double loadFactor = 0.75;
    private int size = 0;

    public Integer put(String key, Integer value) {
        checkTrashhold();
        int index = getIndex(key);

        Entry newEntry = new Entry(key, value, null);

        Entry current = arr[index];
        if (current == null) {
            arr[index] = newEntry;
            size++;
            return null;
        }

        Entry previous = arr[index];
        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                Integer temp = current.value;
                current.value = value;
                size++;
                return temp;
            }

            previous = current;
            current = current.next;
        }

        previous.next = newEntry;
        size++;

        return null;
    }


    public Integer get(String key) {
        int index = getIndex(key);
        Entry current = arr[index];

        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                return current.value;
            }

            current = current.next;
        }

        return null;
    }

    public Integer remove(String key) {
        int index = getIndex(key);
        Entry current = arr[index];

        Entry previous = current;
        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                Integer temp = current.value;

                previous.next = current.next;
                size--;

                return temp;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    private void checkTrashhold() {
        int trashHold = (int) (size * loadFactor);
        if (size == trashHold) {
            rehash();
        }
    }

    private void rehash() {
        //
    }

    private int getIndex(String key) {
        return key == null ? 0 : key.hashCode() & (arr.length - 1);
    }


    public void print() {
        for(Entry item : arr) {
            if (item == null) {
                System.out.println("[]");
                continue;
            }

            System.out.print("[");

            Entry current = item;
            while (current != null) {
                System.out.print(current.key + ":" + current.value + " => ");
                current = current.next;
            }
            System.out.print("]");
            System.out.println();
        }
    }

    static class Entry {
        String key;
        Integer value;
        Entry next;

        public Entry(String key, Integer value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
