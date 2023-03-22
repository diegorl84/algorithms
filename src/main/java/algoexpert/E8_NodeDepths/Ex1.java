package algoexpert.E8_NodeDepths;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static int nodeDepths(BinaryTree root) {
        return calculateDepth(root, 0);
    }

    public static int calculateDepth(BinaryTree node, int depth) {
        if (node == null) {
            return 0;
        }
        int currentDepth = depth + 1;
        return depth + calculateDepth(node.left, currentDepth) + calculateDepth(node.right, currentDepth);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        List<BinaryTree> tree = new ArrayList<>();
        BinaryTree n9 = new BinaryTree(9);
        BinaryTree n8 = new BinaryTree(8);
        BinaryTree n7 = new BinaryTree(7);
        BinaryTree n6 = new BinaryTree(6);
        BinaryTree n5 = new BinaryTree(5);
        BinaryTree n4 = new BinaryTree(4);
        BinaryTree n3 = new BinaryTree(3);
        BinaryTree n2 = new BinaryTree(2);
        BinaryTree n1 = new BinaryTree(1);
//        n4.left = n8;
//        n4.right = n9;
//        n3.left = n6;
//        n3.right = n7;
//        n2.left = n4;
//        n2.right = n5;
//        n1.left = n2;
//        n1.right = n3;

        System.out.println(nodeDepths(n1));
    }
}
