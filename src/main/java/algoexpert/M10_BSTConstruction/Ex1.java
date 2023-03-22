package algoexpert.M10_BSTConstruction;

public class Ex1 {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // Average O(Log(n)) time | O(Log(n)) space
        // Worst O(n) time | O(n)
        public BST insert(int value) {
            if (value < this.value) {
                if(this.left == null){
                    this.left = new BST(value);
                }else{
                    this.left.insert(value);
                }
            } else {
                if (value >= this.value) {
                    if (this.right == null) {
                        this.right = new BST(value);
                    } else {
                        this.right.insert(value);
                    }
                }
            }
            return this;
        }

        // Average O(Log(n)) time | O(Log(n)) space
        // Worst O(n) time | O(n)
        public boolean contains(int value) {
            if (this.value == value) {
                return true;
            } else if (value < this.value && left != null) {
                return left.contains(value);
            } else if (right != null) {
                return right.contains(value);
            }else{
                return false;
            }
        }

        // Average O(Log(n)) time | O(Log(n)) space
        // Worst O(n) time | O(n)
        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            if(value < this.value){
                if(this.left != null){
                    remove(value, this.left);
                }
            }else if(value > this.value){
                if(this.right != null){
                    remove(value, this.right);
                }
            } else{
                if(left != null && right != null){
                    this.value = right.getSmallesRight();
                    right.remove(this.value, this);
                }else if(parent == null){
                    if(left != null){
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    }else if(right != null){
                        this.value = right.value;
                        right = right.right;
                        left = right.left;

                    }
                }else if(parent.left == this){
                    parent.left = left != null ? left : right;
                }else if(parent.right == this){
                    parent.right = left != null ? left : right;
                }
            }
        }

        public int getSmallesRight() {
            if (left == null) {
                return this.value;
            } else {
                return left.getSmallesRight();
            }
        }
    }

    public static void main(String[] args) {
        var root = new Ex1.BST(10);
        root.left = new Ex1.BST(5);
        root.left.left = new Ex1.BST(2);
        root.left.left.left = new Ex1.BST(1);
        root.left.right = new Ex1.BST(5);
        root.right = new Ex1.BST(15);
        root.right.left = new Ex1.BST(13);
        root.right.left.right = new Ex1.BST(14);
        root.right.right = new Ex1.BST(22);

       root.contains(15);
    }
}
