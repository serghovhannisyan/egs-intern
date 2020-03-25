package com.egs.serg.task3;

import java.util.NoSuchElementException;

public class CustomLinkedList {

    private Node head = null;
    private int size;

    public void addFirst(String e) {
        Node newNode = new Node(e);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addLast(String e) {
        Node newNode = new Node(e);

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
        size++;
    }

    public void add(int index, String element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }

        if (index == 0) {
            addFirst(element);
            return;
        }

        if (index == size) {
            addLast(element);
            return;
        }

        int x = 0;
        Node current = head;
        while (x < index) {
            current = current.next;
            x++;
        }

        Node newNode = new Node(element);

        newNode.next = current.next;
        current.next = newNode;

        size++;
    }

    public String removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("error");
        }

        String value = head.value;

        head = head.next;
        size--;

        return value;
    }

    public String removeLast() {
        if (head == null) {
            throw new NoSuchElementException("error");
        }

        if (size == 1) {
            return removeFirst();
        }

        Node current = head;
        int x = 0;
        while (x < size - 1) {
            current = current.next;
        }

        String value = current.next.value;

        current.next = null;
        size--;

        return value;
    }

    public String remove(int index) {
        // TODO() add validation

        Node current = head;
        int x = 0;
        while (x < index - 1) {
            current = current.next;
            x++;
        }

        String value = current.next.value;
        current.next = current.next.next;

        return value;
    }


    void f() {
        Node current1 = head;
        Node current2 = head;

        while (current1.next != null) {
            current1 = current1.next;
        }


        while (current2.next != null) {
            current2 = current2.next;
        }


        boolean result = current1 == current2;

        String value = current1.value;
    }

    static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

}
