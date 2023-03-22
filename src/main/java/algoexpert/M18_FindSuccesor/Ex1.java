package algoexpert.M18_FindSuccesor;

import java.util.ArrayList;

public class Ex1 {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space - Where n is the numbers of nodes in the tree
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        ArrayList<BinaryTree> list = new ArrayList<>();
        traverseTree(tree, list);
        for (int i = 0; i < list.size(); i++){
            if(list.get(i) == node){
                if(i+1 < list.size()){
                    return list.get(i+1);
                }
            }
        }
        return null;
    }

    public void traverseTree(BinaryTree tree, ArrayList<BinaryTree> list){
        if(tree.left != null){
            traverseTree(tree.left, list);
        }
        list.add(tree);
        if(tree.right != null){
            traverseTree(tree.right, list);
        }
    }

    public static void main(String[] args) {

        BinaryTree leaf_6 = new BinaryTree(6);

        BinaryTree leaf_4 = new BinaryTree(4);
        leaf_4.left = leaf_6;

        BinaryTree leaf_5 = new BinaryTree(5);
        BinaryTree leaf_2 = new BinaryTree(2);
        leaf_2.left = leaf_4;
        leaf_2.right = leaf_5;

        BinaryTree leaf_3 = new BinaryTree(3);

        BinaryTree leaf_1 = new BinaryTree(1);
        leaf_1.left = leaf_2;
        leaf_1.right = leaf_3;

        Ex1 ex1 = new Ex1();
        ex1.findSuccessor(leaf_1, leaf_5);
    }
}
