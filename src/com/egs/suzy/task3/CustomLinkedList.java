package com.egs.suzy.task3;


public class CustomLinkedList {
    private Node head = null;
    private int size;

    public void addFirst(Integer e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(Integer e) {
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

        current = newNode;
        size++;
    }

    public void add(int index, Integer e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("wrong index");
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        if (index == size) {
            addLast(e);
            return;
        }
        Node newNode = new Node(e);
        Node prev = head;
        int prevIndex = 0;
        while (prevIndex < index - 1) {
            prev = prev.next;
            prevIndex++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public Integer removeFirst() {
        if (head == null) {
            throw new NullPointerException("error no element to remove");
        }
        Integer value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public Integer removeLast() {
        if (head == null) {
            throw new NullPointerException("no element to remove");
        }
        if (size == 1) {
            removeFirst();
        }
        Node beforeLast = head;
        int prevIndex = 0;
        while (prevIndex < size - 1) {
            beforeLast = beforeLast.next;
            prevIndex++;
        }
        Integer value = beforeLast.next.value;
        beforeLast.next = null;
        size--;
        return value;
    }

    public Integer remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index is out of list");
        }
        if (index == 0) {
            removeFirst();
        }
        if (index == size) {
            removeLast();
        }
        Node prevNode = head;
        int prevIndex = 0;
        while (prevIndex < index - 1) {
            prevNode = prevNode.next;
            prevIndex++;
        }
        Integer value = prevNode.next.value;
        prevNode.next = prevNode.next.next;
        size--;
        return value;
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void deleteList(){
        head = null;
    }

    public int indexOf(Integer value) {
        int i = 0;
        Node current = head;
        while (i < size) {
            if (current.value == value) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    public boolean contains(Integer value) {
        if (indexOf(value) != -1) {
            return true;
        }
        return false;
    }

    public Node node(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of bounds");
        }
        int i = 0;
        Node current = head;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current;
    }

    public Integer[] toArray() {
        Integer[] arr = new Integer[size];
        int i = 0;
        for (Node x = head; x != null; x = x.next) {
            arr[i++] = x.value;
        }
        return arr;
    }

    static class Node {
        int value;
        Node next;
        Node(){

        }
        Node(int d) {
            this.value = d;
        }
    }

}
