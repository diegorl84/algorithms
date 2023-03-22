package algoexpert.M19_HeightBalancedBinaryTree;


// O(n) time, n is the number of nodes
// O(h) space, h is the height of tree, each recursive call will add one in the stack
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

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return getTreeInfo(tree).balanced;

    }
    public TreeInfo getTreeInfo(BinaryTree node) {
        if(node == null){
            return new TreeInfo(true, -1);
        }
        TreeInfo l = getTreeInfo(node.left);
        TreeInfo r = getTreeInfo(node.right);

        boolean isBalanced = r.balanced && r.balanced && Math.abs(r.height - l.height) <= 1;
        int height = Math.max(r.height, l.height) + 1;
        return new TreeInfo(isBalanced, height);

    }

    static class TreeInfo{
        public boolean balanced;
        public int height;

        public TreeInfo(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }


    public static void main(String[] args) {

        BinaryTree leaf_8 = new BinaryTree(8);
        BinaryTree leaf_9 = new BinaryTree(9);
        BinaryTree leaf_4 = new BinaryTree(4);
        leaf_4.left = leaf_8;
        leaf_4.right = leaf_9;

        BinaryTree leaf_10 = new BinaryTree(10);
        BinaryTree leaf_9b = new BinaryTree(9);
        BinaryTree leaf_5 = new BinaryTree(5);
        leaf_5.left = leaf_9b;
        leaf_5.right = leaf_10;


        BinaryTree leaf_2 = new BinaryTree(2);
        leaf_2.left = leaf_4;
        leaf_2.right = leaf_5;

        BinaryTree leaf_13 = new BinaryTree(13);
        BinaryTree leaf_12 = new BinaryTree(12);
        leaf_12.right = leaf_13;

        BinaryTree leaf_6 = new BinaryTree(6);
        leaf_6.right = leaf_12;

        BinaryTree leaf_7 = new BinaryTree(7);
        BinaryTree leaf_3 = new BinaryTree(3);
        leaf_3.left = leaf_6;
        leaf_3.right = leaf_7;


        BinaryTree leaf_1 = new BinaryTree(1);
        leaf_1.left = leaf_2;
        leaf_1.right = leaf_3;

        Ex1 ex1 = new Ex1();
        ex1.heightBalancedBinaryTree(leaf_1);
    }
}
