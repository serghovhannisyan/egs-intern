package com.egs.arsensargsyan.task3;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        System.out.println(binarySearchTree.put(8, "A"));
        System.out.println(binarySearchTree.put(6, "B"));
        System.out.println(binarySearchTree.put(1, "C"));
        System.out.println(binarySearchTree.put(13, "D"));
        System.out.println(binarySearchTree.put(5, "E"));
        System.out.println(binarySearchTree.put(2, "J"));
        System.out.println(binarySearchTree.put(2, "BA"));

        System.out.println("________test get__________________");
        System.out.println(binarySearchTree.get(8));
        System.out.println(binarySearchTree.get(6));
        System.out.println(binarySearchTree.get(1));
        System.out.println(binarySearchTree.get(13));
        System.out.println(binarySearchTree.get(5));
        System.out.println(binarySearchTree.get(2));
        System.out.println(binarySearchTree.get(2));

    }
}
