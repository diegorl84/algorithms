package leedcode.top100likedQuestions;

import principles.util.ListNode;

public class T_21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode root = new ListNode(0);
        ListNode head = root;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode newNode = new ListNode(list1.val);
                root.next = newNode;
                list1 = list1.next;
            }else if(list1.val > list2.val){
                ListNode newNode = new ListNode(list2.val);
                root.next = newNode;
                list2 = list2.next;
            }else{
                ListNode newNode = new ListNode(list1.val, new ListNode(list2.val));
                root.next = newNode;
                list1 = list1.next;
                list2 = list2.next;
                root = root.next;
            }
            root = root.next;
        }
        if(list1 != null){
            root.next = list1;
        }else if(list2 != null){
            root.next = list2;
        }
        return head.next;
    }
}
