package task3;

import task3.BinarTree;

public class Main {
    public static void main(String[] args) {
        BinarTree tree = new BinarTree(null);
        BinarTree.Node root = new BinarTree.Node(17, "aa");
        tree.setRoot(root);
        tree.insert(root, 13, "bb");
        tree.insert(root, 18, "cc");
        tree.insert(root, 10, "dd");
        tree.insert(root, 9, "hh");
        tree.insert(root, 27, "hh");
        tree.printTraversal(root);
        tree.get(root, 10);
        tree.removeNode(root,10);
        tree.printTraversal(root);
    }
}

