package algoexpert.M17_BinaryTreeDiameter;

public class Ex1 {

  public int binaryTreeDiameter(BinaryTree tree) {
    return getTreeInfo(tree).diameter;
  }

  public TreeInfo getTreeInfo(BinaryTree tree){
    if(tree == null){
      return new TreeInfo(0,0);
    }
    TreeInfo leftTreeInfo = getTreeInfo(tree.left);
    TreeInfo rightTreeInfo = getTreeInfo(tree.right);

    int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;
    int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
    int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
    int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

    return new TreeInfo(currentDiameter, currentHeight);
  }

  static class TreeInfo{
    public int diameter;
    public int height;

    public TreeInfo(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }

  static class BinaryTree{
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value){
      this.value = value;
    }
  }

  public static void main(String[] args) {
    BinaryTree leaf_9 = new BinaryTree(9);
    BinaryTree leaf_8 = new BinaryTree(8);
    leaf_8.left = leaf_9;
    BinaryTree leaf_7 = new BinaryTree(7);
    leaf_7.left = leaf_8;

    BinaryTree leaf_6 = new BinaryTree(6);
    BinaryTree leaf_5 = new BinaryTree(5);
    leaf_5.right = leaf_6;
    BinaryTree leaf_4 = new BinaryTree(4);
    leaf_4.right = leaf_5;

    BinaryTree leaf_3 = new BinaryTree(3);
    leaf_3.left = leaf_7;
    leaf_3.right = leaf_4;

    BinaryTree leaf_2 = new BinaryTree(2);

    BinaryTree leaf_1 = new BinaryTree(1);
    leaf_1.left = leaf_3;
    leaf_1.right = leaf_2;

    Ex1 ex1 = new Ex1();
    System.out.println(ex1.binaryTreeDiameter(leaf_1));




  }

}


