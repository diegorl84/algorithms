package algoexpert.E13_RemoveDuplicatesFromLinkedList;

public class Ex1 {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while( currentNode != null){
            LinkedList nextNode = currentNode.next;
            while(nextNode != null && nextNode.value == currentNode.value){
                nextNode = nextNode.next;
            }
            currentNode.next = nextNode;
            currentNode = currentNode.next;

        }
        return linkedList;
    }
}
