package com.egs.suzy.task4;


public class CustomHashMap {
    private Entry[] arr = new Entry[16];
    private double loadFactor = 0.75;
    private int size = 0;

    public Integer put(String key, Integer value) {
        checkThreshold();
        int index = getIndex(key);

        Entry newNode = new Entry(key, value, null);
        Entry current = arr[index];
        if (current == null) {
            arr[index] = newNode;
            size++;
            return null;
        }
        Entry previous = arr[index];
        while (current != null) {
            if (key.hashCode() == current.key.hashCode()
                    && key.equals(current.key)) {
                Integer temp = current.value;
                current.value = value;
                return temp;
            }
            previous = current;
            current = current.next;
        }
        previous.next = newNode;
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

    private void checkThreshold() {
        int threshHold = (int) (arr.length * loadFactor);
        if (size == threshHold) {
            rehash();
        }
    }

    private void rehash() {
        Entry[] newArr = new Entry[2 * arr.length];

        for (Entry e : arr) {
            if (e != null) {
                int index = getIndex(e.key);

                Entry current = newArr[index];
                if (current == null) {
                    newArr[index] = e;
                } else {
                    Entry previous = newArr[index];
                    while (current != null) {
                        if (e.key.hashCode() == current.key.hashCode()
                                && e.key.equals(current.key)) {
                            Integer temp = current.value;
                            current.value = e.value;
                        }
                        previous = current;
                        current = current.next;
                    }
                    previous.next = e;
                }
            }
        }
        arr = newArr;
    }

    private int getIndex(String key) {
        return key == null ? 0 : key.hashCode() & (arr.length - 1);
    }

    public void print() {
        for (CustomHashMap.Entry item : arr) {
            if (item == null) {
                System.out.println("[]");
                continue;
            }

            System.out.print("[");

            CustomHashMap.Entry current = item;
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

        public Entry(String key, Integer value, CustomHashMap.Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
