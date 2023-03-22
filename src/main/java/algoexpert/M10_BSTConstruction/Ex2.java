package algoexpert.M10_BSTConstruction;

public class Ex2 {

  static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    // Average O(Log(n)) time | O(1) space
    // Worst O(n) time | O(1)
    public BST insert(int value) {
      BST currentNode = this;
      while (true) {
        if (value < currentNode.value) {
          if (currentNode.left == null) {
            currentNode.left = new BST(value);
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          if (currentNode.right == null) {
            currentNode.right = new BST(value);
            break;
          } else {
            currentNode = currentNode.right;
          }
        }
      }
      return this;
    }

    // Average O(Log(n)) time | O(1) space
    // Worst O(n) time | O(1)
    public boolean contains(int value) {
      BST currentNode = this;
      while (currentNode != null) {
        if (currentNode.value == value) {
          return true;
        } else if (value < currentNode.value) {
          currentNode = currentNode.left;
        } else {
          currentNode = currentNode.right;
        }
      }
      return false;

    }

    // Average O(Log(n)) time | O(1) space
    // Worst O(n) time | O(1)
    public BST remove(int value) {
      remove(value, null);
      return this;
    }

    public void remove(int value, BST parentNode) {
      BST currentNode = this;
      while (currentNode != null) {
        if (value < currentNode.value) {
          parentNode = currentNode;
          currentNode = currentNode.left;
        } else if (value > currentNode.value) {
          parentNode = currentNode;
          currentNode = currentNode.right;
        } else {
          if (currentNode.left != null && currentNode.right != null) {
            currentNode.value = currentNode.right.getSmallesRight();
            currentNode.right.remove(currentNode.value, currentNode);
          } else if (parentNode == null) {
            if (currentNode.left != null) {
              currentNode.value = currentNode.left.value;
              currentNode.right = currentNode.left.right;
              currentNode.left = currentNode.left.left;
            } else if (currentNode.right != null) {
              currentNode.value = currentNode.right.value;
              currentNode.right = currentNode.right.right;
              currentNode.left = currentNode.right.left;

            }
          } else if (parentNode.left == this) {
            parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
          } else if (parentNode.right == this) {
            parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
          }
          break;
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
    var root = new Ex2.BST(10);
    root.left = new Ex2.BST(5);
    root.left.left = new Ex2.BST(2);
    root.left.left.left = new Ex2.BST(1);
    root.left.right = new Ex2.BST(5);
    root.right = new Ex2.BST(15);
    root.right.left = new Ex2.BST(13);
    root.right.left.right = new Ex2.BST(14);
    root.right.right = new Ex2.BST(22);

    root.contains(15);
  }
}
