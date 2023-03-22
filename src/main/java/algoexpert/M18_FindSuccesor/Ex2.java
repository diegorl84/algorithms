package algoexpert.M18_FindSuccesor;

public class Ex2 {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(h) time | O(1) space - Where h is the height of the tree
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
       if(node.right != null){
           return getLeftMostChild(node.right);
       }
       return getRightmostParent(node);
    }

    public BinaryTree getLeftMostChild(BinaryTree node){
        BinaryTree currentNode = node;
        while(node.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public BinaryTree getRightmostParent(BinaryTree node){
        BinaryTree currentNode = node;
        while(currentNode.parent != null && currentNode.parent.right == currentNode){
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
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

        Ex2 ex1 = new Ex2();
        BinaryTree f = new BinaryTree(5);
        ex1.findSuccessor(leaf_1, f);
    }
}
