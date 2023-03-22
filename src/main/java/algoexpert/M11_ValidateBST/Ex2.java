package algoexpert.M11_ValidateBST;

public class Ex2 {
  public static boolean validateBst(BST tree) {
    boolean lv = true;
    boolean rv = true;

    if(tree.left != null){
      if(tree.left.value < tree.value)
        lv = validateBst(tree.left);
      else
        lv = false;
    }
    if(tree.right != null ){
      if(tree.right.value >= tree.value)
        rv = validateBst(tree.right);
      else
        rv = false;
    }
    return lv && rv;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    var root = new Ex2.BST(10);
    root.left = new Ex2.BST(5);
    root.right = new Ex2.BST(15);
    root.left.right = new BST(10);

    System.out.println(validateBst(root));



  }
}
