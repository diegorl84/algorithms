package algoexpert.E7_BranchSums;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity O(n)
 * Space complexity
 */
public class Ex1 {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        calculateSums(root, 0, sums);
        return sums;
    }

    public static void calculateSums(BinaryTree node, int currentSum, List<Integer> sums) {
        if (node == null) return;
        currentSum += node.value;

        if (node.left == null && node.right == null) {
            sums.add(currentSum);
        }

        calculateSums(node.left, currentSum, sums);
        calculateSums(node.right, currentSum, sums);

    }
}
