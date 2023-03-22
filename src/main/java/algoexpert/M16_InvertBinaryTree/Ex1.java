package algoexpert.M16_InvertBinaryTree;

import algoexpert.common.BinaryTree;

public class Ex1 {
  public static void invertBinaryTree(BinaryTree tree) {
    BinaryTree temp = tree.left;
    tree.left = tree.right;
    tree.right = temp;
    if(tree.left != null){
      invertBinaryTree(tree.left);
    }
    if(tree.right != null){
      invertBinaryTree(tree.right);
    }
  }

  public static void main(String[] args) {

  }

}
