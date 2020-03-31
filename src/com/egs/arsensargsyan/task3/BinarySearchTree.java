package com.egs.arsensargsyan.task3;

public class BinarySearchTree {
    private int size = 0;
    private Node root = null;


    int getSize() {
        return size;
    }

    public String put(Integer key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            size++;
            return null;
        } else {
            Node current = root;
            while (true) {
                if (newNode.key > current.key) {
                    if (current.left != null) {
                        current = current.left;
                    } else {
                        current.left = newNode;
                        size++;
                        return null;
                    }

                } else if (newNode.key < current.key) {
                    if (current.right != null) {
                        current = current.right;
                    } else {
                        current.right = newNode;
                        size++;
                        return null;
                    }

                } else {
                    String temp = current.value;
                    current.value = newNode.value;
                    return temp;
                }
            }
        }
    }

    public String get(Integer key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return current.value;
            }
            if (key > current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    public String remove(Integer key) {
        return null;
    }

    static class Node {
        private Integer key;
        private String value;
        private Node left;
        private Node right;

        private Node(Integer key, String value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}