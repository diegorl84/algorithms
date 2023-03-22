package algoexpert.M13_MinHeightBST;

import java.util.List;

/**
 * O(nLog(n)) time
 * O(n) space
 */
public class Ex1 {

  public static BST minHeightBst(List<Integer> array) {
    return minHeightBst(array, null, 0, array.size() - 1);
  }

  public static BST minHeightBst(List<Integer> array, BST tree, int l, int r) {
    if (r < l) {
      return null;
    }
    int mid = (l + r) / 2;
    int valueToAdd = array.get(mid);
    if (tree == null) {
      tree = new BST(valueToAdd);
    } else {
      tree.insert(valueToAdd);
    }
    minHeightBst(array, tree, l, mid - 1);
    minHeightBst(array, tree, mid + 1, r);
    return tree;
  }

  static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
      left = null;
      right = null;
    }

    public void insert(int value) {
      if (value < this.value) {
        if (left == null) {
          left = new BST(value);
        } else {
          left.insert(value);
        }
      } else {
        if (right == null) {
          right = new BST(value);
        } else {
          right.insert(value);
        }
      }
    }
  }
}
