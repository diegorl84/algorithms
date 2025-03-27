package algoexpert.E7_FindClosestValueInBST;

import algoexpert.common.BST;

/**
 * Iteration
 * Time complexity: average O(n), worst O(n) scenario a BST with only one branch
 * Space complexity: average O(1)
 * Be aware of using closest as Integer.MAX_VALUE and target -1, Math.abs(Integer.MIN_VALUE) return a negative
 * NOTE: Recall that the range of integers that can be represented in 32 bits is -2,147,483,648 – 2,147,483,647. That is, the true absolute value of Integer.MIN_VALUE can not be represented as an int.
 */
public class Solution {
    public static int findClosestValueInBst(BST tree, int target) {

        BST currentNode = tree;
        int closest = currentNode.value;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(currentNode.value - target)) {
                closest = currentNode.value;
            }

            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }
        return closest;
    }

    /**
     * Recursion
     * Time complexity: average O(log(n), worst O(n) scenario a BST with only one branch
     * Space complexity: average O(log(d)) d as depth of the tree, every recursion adds an object to the call stack
     */
    public static int findClosestValueInBst_recursive(BST tree, int target) {
        return findClosesValue(tree, target, Integer.MAX_VALUE);
    }

    public static int findClosesValue(BST tree, int target, int closest) {

        if (tree == null) {
            return closest;
        }
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }
        if (target < tree.value) {
            return findClosesValue(tree.left, target, closest);
        } else if (target > tree.value) {
            return findClosesValue(tree.right, target, closest);
        } else {
            return closest;
        }
    }


    public static void main(String[] args) {
        BST bst = BST.createBST(new int[]{10, 5, 15, 2, 5, 13, 22, 1, 14});
        System.out.println(findClosestValueInBst_recursive(bst, -1));
    }
}
