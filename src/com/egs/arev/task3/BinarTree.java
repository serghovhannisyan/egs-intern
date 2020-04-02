package task3;

public class BinarTree {
    private Node root;

    public BinarTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    static class Node {
        Node right, left;
        int key;
        String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    public Node insert(Node root, int key, String value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }
        if (key < root.key) {
            root.left = insert(root.left, key, value);
        } else if (key > root.key) {
            root.right = insert(root.right, key, value);
        } else
            root.value = value;
        return root;
    }

    void printTraversal(Node root) {
        if (root != null) {
            printTraversal(root.left);
            printTraversal(root.right);
            System.out.println(root.key);
        }
    }

    void get(Node root, int key) {
        if (root == null)
            System.out.println("There is not such key in the tree.");
        else {
            if (root.key == key)
                System.out.println(root.value);
            else if (key < root.key) {
                get(root.left, key);
            } else
                get(root.left, key);
        }
    }

    Node removeNode(Node root, int key) {
        if (root == null)
            return root;

        if (root.key < key)
            root.right = removeNode(root.right, key);
        else if (root.key > key)
            root.left = removeNode(root.left, key);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minKey(root.right);
            root.right = removeNode(root.right, root.key);
        }
        return root;
    }

    int minKey(Node root) {
        int min = root.key;
        while (root.left != null) {
            min = root.left.key;
            root = root.left;
        }
        return min;
    }
}