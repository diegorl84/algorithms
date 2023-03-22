package leedcode.top_interview_questions_medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenFirst = even;
        while (1 == 1){
            if(odd == null || even == null || even.next == null){
                odd.next = evenFirst;
                break;
            }
            odd.next = even.next;
            odd = even.next;

            if(odd.next == null){
                even.next = null;
                odd.next = evenFirst;
                break;
            }
            even.next = odd.next;
            even = odd.next;
        }

        return head;
    }
    @Test
    public void TestCase1() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3,four);
        ListNode two = new ListNode(2,three);
        ListNode root = new ListNode(1, two);

        ListNode answer = new ListNode();

        Assert.assertTrue(compare(oddEvenList(root),answer));
    }

    public static boolean compare(ListNode n1, ListNode n2){
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}