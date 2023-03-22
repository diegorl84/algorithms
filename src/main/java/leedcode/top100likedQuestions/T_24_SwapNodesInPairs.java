package leedcode.top100likedQuestions;

import org.junit.Test;
import principles.util.ListNode;

import java.util.List;

public class T_24_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode();
        ListNode prevNode = root;
        ListNode currNode = head;

        while(currNode != null && currNode.next != null){
            prevNode.next = currNode.next;
            currNode.next = prevNode.next.next;
            prevNode.next.next = currNode;
            prevNode = currNode;
            currNode = currNode.next;
        }
        return root.next;
    }
    @Test
    public void test(){
        ListNode root = ListNode.createListFromList(List.of(1,2,3,4));
        ListNode ans = swapPairs(root);
        System.out.println(ans);
    }
}
