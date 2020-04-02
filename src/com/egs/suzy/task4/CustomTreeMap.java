package com.egs.suzy.task4;

public class CustomTreeMap {
    //private static final boolean RED = true;
    // private static final boolean BLACK = false;
    private int size;
    private Node root;

    CustomTreeMap() {
    }

    public String put(Integer key, String value) {
        Node newNode = new Node(key, value);
        insertBST(newNode);
        return null;
    }

    public String remove(Integer key) {
        Node node = getNode(key);
        if (node == null) {
            return null;
        }
        String value = node.value;
        if (node.left == null && node.right == null) {
            node = null;
            return value;
        }
        if (node.right == null && node.left != null) {
            node = node.left;
            node.left = null;
            return value;
        }
        if (node.right != null && node.left == null) {
            node = node.right;
            node.right = null;
            return value;
        }
        Node rightMin = node.right;
        while (rightMin.left != null) {
            rightMin = rightMin.left;
        }
        node.key = rightMin.key;
        node.value = rightMin.value;
        rightMin = null;

        return value;
    }

    private String insertBST(Node newNode) {
        if (root == null) {
            root = newNode;
            size++;
            return null;
        }
        Node current = root;
        while (true) {
            if (current.value == newNode.value) {
                return current.value;
            }
            if (newNode.key < current.key) {
                if (current.left == null) {
                    current.left = newNode;
                    newNode.parent = current;
                    size++;
                    return null;
                }
                current = current.left;
            }
            if (newNode.key > current.key) {
                if (current.right == null) {
                    current.right = newNode;
                    newNode.parent = current;
                    size++;
                    return null;
                }
                current = current.right;
            }
        }
    }

    public Node getNode(Integer key) {
        if (root == null) {
            throw new NullPointerException("tree is empty");
        }
        Node current = root;
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            if (key < current.key) {
                current = current.left;
            }
            current = current.right;
        }
        return null;
    }

    public String get(Integer key) {
        Node node = getNode(key);
        return node.value;
    }
    /*private void fixRedBlackTree(Node node) throws Exception {
            if(node == root){
                root.color = BLACK;
                return;
            }

        while (node.parent != root && node.parent.color == RED) {
            if(node.parent.parent.left.color == RED){
                flipColors(node.parent);
                node = node.parent.parent;
            }
            if(node.parent.parent.left.color == BLACK){
                if(node == node.parent.left){
                    rotateRight(node.parent);
                    node.parent.color = !node.parent.color;
                    node.parent.left.color = !node.parent.left.color;
                }
                else if(node == node.parent.right){

                }
            }
        }
        root.color = BLACK;

    }
    private void rotateRight(Node parent){
        Node grandparent = parent.parent;
        parent.parent = grandparent.parent;
        parent.parent.left = grandparent;
    }

    private void rotateLeft(Node current) {

    }

    private void flipColors(Node parent) {
        parent.color = !parent.color;
        parent.parent.color = !parent.parent.color;
        parent.parent.left.color = !parent.parent.left.color;
    }*/

    static class Node {
        Integer key;
        String value;
        //   boolean color = BLACK;
        Node left;
        Node right;
        Node parent;

        /*  public Node(Integer key , String val, boolean col) {
              this.key = key;
              this.value = val;
              this.color = col;
          }*/
        public Node(Integer key, String val) {
            this.key = key;
            this.value = val;
        }
    }
}
