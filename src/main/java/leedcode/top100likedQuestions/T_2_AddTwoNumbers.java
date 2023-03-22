package leedcode.top100likedQuestions;

import org.junit.Test;
import principles.util.ListNode;

import java.util.Arrays;

public class T_2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int firstNum = l1 == null ? 0 : l1.val;
            int secondNum = l2 == null ? 0 : l2.val;

            int sum = carry + firstNum + secondNum;

            if(sum > 9){
                sum = sum - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            result.next = new ListNode(sum);
            result = result.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }

    @Test
    public void test(){
        addTwoNumbers(ListNode.createListFromList(Arrays.asList(2,4,3)), ListNode.createListFromList(Arrays.asList(5,6,4)));
    }
}
