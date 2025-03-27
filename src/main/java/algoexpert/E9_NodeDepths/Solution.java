package algoexpert.E9_NodeDepths;

import algoexpert.common.BinaryTree;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    /**
     * Average case when tree is balanced
     * Time complexity: O(n)
     * Space complexity: O(h) h as height of the binary tree
     */
    public static int nodeDepths(BinaryTree root) {
        return calculateDepth(root, 0);
    }

    public static int calculateDepth(BinaryTree currentNode, int currentDepth) {

        if (currentNode == null) {
            return 0;
        }
        return currentDepth + calculateDepth(currentNode.left, currentDepth + 1) + calculateDepth(currentNode.right, currentDepth + 1);
    }

    public static int nodeDepths_2(BinaryTree root) {
        int sumDepths = 0;
        List<Level> stack = new ArrayList<>();
        stack.add(new Level(root, 0));
        while (stack.size() > 0) {
            Level top = stack.remove(stack.size() - 1);
            BinaryTree node = top.root;
            int depth = top.depth;

            if (node == null) continue;
            sumDepths += depth;
            stack.add(new Level(node.left, depth + 1));
            stack.add(new Level(node.right, depth + 1));
        }
        return sumDepths;


    }

    static class Level {
        public BinaryTree root;
        int depth;

        public Level(BinaryTree root, int depth) {
            this.root = root;
            this.depth = depth;
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        BinaryTree binaryTree_2 = new BinaryTree(2);
        BinaryTree binaryTree_3 = new BinaryTree(3);
        BinaryTree binaryTree_4 = new BinaryTree(4);
        BinaryTree binaryTree_5 = new BinaryTree(5);
        BinaryTree binaryTree_6 = new BinaryTree(6);
        BinaryTree binaryTree_7 = new BinaryTree(7);
        BinaryTree binaryTree_8 = new BinaryTree(8);
        BinaryTree binaryTree_9 = new BinaryTree(9);
        binaryTree.left = binaryTree_2;
        binaryTree.right = binaryTree_3;
        binaryTree_2.left = binaryTree_4;
        binaryTree_2.right = binaryTree_5;
        binaryTree_3.left = binaryTree_6;
        binaryTree_3.right = binaryTree_7;
        binaryTree_4.left = binaryTree_8;
        binaryTree_4.right = binaryTree_9;
        System.out.println(nodeDepths_2(binaryTree));
    }
}
