package algoexpert.M15_ReconstructBST;

import algoexpert.common.BST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex2 {

  public BST reconstructBst(List<Integer> values) {
    Integer rootIdx = 0;
    return reconstructBst(Integer.MIN_VALUE, Integer.MAX_VALUE, values, rootIdx);

  }

  public BST reconstructBst(int lower, int upper, List<Integer> preOrderTraversalValues, Integer rootIdx) {
    if(rootIdx == preOrderTraversalValues.size()){
      return null;
    }
    int rootValue = preOrderTraversalValues.get(rootIdx);
    if(rootValue < lower || rootValue > upper){
      return null;
    }
    rootIdx++;
    BST leftTree = reconstructBst(lower, rootValue, preOrderTraversalValues, rootIdx);
    BST rightTree = reconstructBst(rootValue, upper, preOrderTraversalValues, rootIdx);
    BST bst = new BST(rootValue);
    bst.left = leftTree;
    bst.right = rightTree;

    return bst;
  }

  public static void main(String[] args) {
    Ex1 ex1 = new Ex1();
    ArrayList<Integer> listValues = new ArrayList<>();
    Collections.addAll(listValues, 10, 4, 2, 1, 5, 17, 19, 18);
    BST bst = ex1.reconstructBst(listValues);
    algoexpert.M12_BSTTraversal.Ex1 scanner = new algoexpert.M12_BSTTraversal.Ex1();
    List<Integer> treeList = new ArrayList<>();
    scanner.preOrderTraverse(bst, treeList).forEach(System.out::println);

  }

}
