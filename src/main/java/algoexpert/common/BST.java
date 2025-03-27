package algoexpert.common;

public class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
        this.value = value;
    }

    public static BST createBST(int[] values) {
        BST bst = new BST(values[0]);
        for (int i = 1; i < values.length; i++) {
            searchInsert(bst, values[i]);
        }
        return bst;
    }

    public static void searchInsert(BST node, int val){
        if (val < node.value ) {
            if (node.left != null) {
                searchInsert(node.left, val);
            } else {
                node.left = new BST(val);
            }
        } else {
            if (node.right != null) {
                searchInsert(node.right, val);
            } else {
                node.right = new BST(val);
            }
        }
    }
}