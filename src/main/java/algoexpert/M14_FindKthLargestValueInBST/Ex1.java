package algoexpert.M14_FindKthLargestValueInBST;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

  static class BST {

    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }

  public int findKthLargestValueInBst(BST tree, int k) {
    List<Integer> array = new ArrayList<>();
    return findKthLargestValueInBst(tree, k, array);
  }

  public int findKthLargestValueInBst(BST tree, int k, List<Integer> array) {
    if (tree.right != null) {
      findKthLargestValueInBst(tree.right, k, array);
    }
    array.add(tree.value);
    if (array.size() - 1 == k) {
      return array.get(k);
    }
    if (tree.left != null) {
      findKthLargestValueInBst(tree.left, k, array);
    }
    return 0;
  }

}
