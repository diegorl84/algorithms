package algoexpert.E8_BranchSums;

import algoexpert.common.BinaryTree;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> sums = new ArrayList<>();
        calculateSum(root, 0, sums);

        return sums;
    }

    public static void calculateSum(BinaryTree currentNode, int sum, ArrayList<Integer> results) {
        if(currentNode == null){
            return;
        }
        sum += currentNode.value;
        if (currentNode.right == null && currentNode.left == null) {
            results.add(sum);
            return;
        }
        calculateSum(currentNode.left, sum, results);
        calculateSum(currentNode.right, sum, results);

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
        BinaryTree binaryTree_10 = new BinaryTree(10);
        binaryTree.left = binaryTree_2;
        binaryTree.right = binaryTree_3;
        binaryTree_2.left = binaryTree_4;
        binaryTree_2.right = binaryTree_5;
        binaryTree_3.left = binaryTree_6;
        binaryTree_3.right = binaryTree_7;
        binaryTree_4.left = binaryTree_8;
        binaryTree_4.right = binaryTree_9;
        binaryTree_5.left = binaryTree_10;
        branchSums(binaryTree).forEach(System.out::println);
    }
}
