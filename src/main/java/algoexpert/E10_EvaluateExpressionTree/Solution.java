package algoexpert.E10_EvaluateExpressionTree;

public class Solution {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    /**
     * Average case when tree is balanced
     * Time complexity: O(n)
     * Space complexity: O(h) h as height of the binary tree
     */
    public static int evaluateExpressionTree(BinaryTree tree) {
        return calculateExpression(tree, 0);
    }

    public static int calculateExpression(BinaryTree currentNode, int result) {
        if (currentNode.value == -1) {
            return calculateExpression(currentNode.left, result) + calculateExpression(currentNode.right, result);
        } else if (currentNode.value == -2) {
            return calculateExpression(currentNode.left, result) - calculateExpression(currentNode.right, result);
        } else if (currentNode.value == -3) {
            return Math.round(calculateExpression(currentNode.left, result) / calculateExpression(currentNode.right, result));
        } else if (currentNode.value == -4) {
            return calculateExpression(currentNode.left, result) * calculateExpression(currentNode.right, result);
        }
        return currentNode.value;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(-1);
        BinaryTree binaryTree_2 = new BinaryTree(-2);
        BinaryTree binaryTree_3 = new BinaryTree(-3);
        BinaryTree binaryTree_4 = new BinaryTree(-4);
        BinaryTree binaryTree_5 = new BinaryTree(2);
        BinaryTree binaryTree_6 = new BinaryTree(8);
        BinaryTree binaryTree_7 = new BinaryTree(3);
        BinaryTree binaryTree_8 = new BinaryTree(2);
        BinaryTree binaryTree_9 = new BinaryTree(3);
        binaryTree.left = binaryTree_2;
        binaryTree.right = binaryTree_3;
        binaryTree_2.left = binaryTree_4;
        binaryTree_2.right = binaryTree_5;
        binaryTree_3.left = binaryTree_6;
        binaryTree_3.right = binaryTree_7;
        binaryTree_4.left = binaryTree_8;
        binaryTree_4.right = binaryTree_9;
        System.out.println(evaluateExpressionTree(binaryTree));
    }

}
