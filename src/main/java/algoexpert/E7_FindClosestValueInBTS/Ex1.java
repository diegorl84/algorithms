package algoexpert.E7_FindClosestValueInBTS;


/**
 * BTS trees are O(log n) time complexity. Because in which time we eliminate half of thew options
 * Time complexity: O(log n) time, Worst: O(n) when is only one branch.
 * Space: O(log n) adding frames on the call stack. O(k) -> where K is depth or high of the tree.
 *
 */
public class Ex1 {

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        if(Math.abs(target - closest) > Math.abs(target-tree.value) ){
            closest = tree.value;
        }
        if(target < tree.value && tree.left != null ){
            return findClosestValueInBst(tree.left, target, closest);
        }else if(target > tree.value && tree.right != null ){
            return findClosestValueInBst(tree.right, target, closest);
        }else{
            return closest;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
