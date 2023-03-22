package algoexpert.M15_ReconstructBST;

import algoexpert.common.BST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex1 {

  public BST reconstructBst(List<Integer> values) {
    if(values.isEmpty()){
      return null;
    }

    int currentValue = values.get(0);
    int right = values.size();

    for(int idx = 1; idx < values.size() ; idx++){
      int value = values.get(idx);
      if(value >= currentValue){
        right = idx;
        break;
      }
    }
//    BST leftNode = reconstructBst(values.subList(1, right));
//    BST rightNode = reconstructBst(values.subList(right+1, values.size()));
    BST node = new BST(currentValue);
    node.left = reconstructBst(values.subList(1, right));
    node.right = reconstructBst(values.subList(right, values.size()));
    return node;
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
