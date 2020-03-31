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
            return put(root, newNode);
        }

    }

    private String put(Node current, Node newNode) {
        if (newNode.key > current.key) {
            if (current.left != null) {
                return put(current.left, newNode);
            } else {
                current.left = newNode;
                size++;
                return null;
            }

        } else if (newNode.key < current.key) {
            if (current.right != null) {
                return put(current.right, newNode);
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

    public String get(Integer key) {
        if (key.equals(root.key)) {
            return root.value;
        } else {
            return get(root, key);
        }

    }

    private String get(Node current, Integer key) {
        if (key > current.key) {
            if (current.left != null) {
                return get(current.left, key);
            } else {
                return null;
            }
        } else if (key < current.key) {
            if (current.right != null) {
                return get(current.right, key);
            } else {
                return null;
            }
        } else {
            return current.value;
        }

    }

    public String remove(Integer key) {

        return null;
    }

    static class Node {
        private Integer key;
        private String value;
        private Node left;
        private Node right;

        //Node constructor
        private Node(Integer key, String value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }
}

