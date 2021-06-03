package search;

public class SubListSearch {

  public boolean search(Node first, Node second) {

    Node ptr1 = first, ptr2 = second;

    if (first == null && second == null) {
      return true;
    }
    if (first == null || (first != null && second == null)) {
      return false;
    }

    while (second != null) {
      ptr2 = second;
      while (ptr1 != null) {
        if(ptr2 == null){
          return false;
        }else if(ptr1.value == ptr2.value){
          ptr1 = ptr1.next;
          ptr2 = ptr2.next;
        }else{
          break;
        }

      }

      if(ptr1 == null){
        return true;
      }
      ptr1 = first;
      second = second.next;
    }
    return false;
  }

  // Function to add new node to linked lists
  static Node newNode(int key) {
    Node temp = new Node();
    temp.value = key;
    temp.next = null;
    return temp;
  }

  public static void main(String[] args) {
    SubListSearch sls = new SubListSearch();
    Node a = newNode(1);
    a.next = newNode(2);
    a.next.next = newNode(3);
    a.next.next.next = newNode(4);

    Node b = newNode(1);
    b.next = newNode(2);
    b.next.next = newNode(1);
    b.next.next.next = newNode(2);
    b.next.next.next.next = newNode(3);
    b.next.next.next.next.next = newNode(4);
    if(sls.search(a, b)){
      System.out.println("FOUND");
    }else{
      System.out.println("NOT FOUND");
    }

  }
}

class Node {
  public int value;
  public Node next;
}
