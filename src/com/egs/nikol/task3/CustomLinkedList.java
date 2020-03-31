package com.egs.nikol.task3;

import java.util.NoSuchElementException;

public class CustomLinkedList {
    private Node head = null;
    private int size;

    public void addFirst(String value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void addLast(String value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void add(int index, String value) {
        Node newNode = new Node(value);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        int x = 0;
        Node current = head;

        while (x < index) {
            current = current.next;
            x++;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;

    }

    public String removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        String value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public String removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (size == 1) {
            removeFirst();
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        String value = current.value;
        current = null;
        size--;
        return value;
    }

    public String remove(int index) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }
        if (index == 0) {
            removeFirst();
        }
        if (index == size) {
            removeLast();
        }
        Node current = head;
        int x = 0;
        while (x < index - 1) {
            current = current.next;
            x++;
        }
        String value = current.next.value;
        current.next = current.next.next;
        size--;
        return value;
    }

    //returns loops position by index. if there are not loop it returns  -1

    public int hasLoop() {
        if (head.next == null) {
            return -1;
        }
        Node current = head;
        Node point = head.next;
        int loopsPosition = 0;
        while (point != null) {
            if (current == point) {
                point = head;
                while (true) {
                    current = current.next;
                    if (current == point) {
                        return loopsPosition;
                    }
                    point = point.next;
                }
            }
            current = current.next;
            point = point.next.next;
        }

        return -1;
    }

    static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }
}
