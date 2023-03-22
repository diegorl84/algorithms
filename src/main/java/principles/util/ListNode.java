package principles.util;


import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createListFromList(List<Integer> list){
        ListNode root = new ListNode(list.get(0));

        ListNode head = root;
        for (int i = 1; i < list.size() ; i++) {
            while(root.next == null){
                root.next = new ListNode(list.get(i));
            }
            root = root.next;
        }
       return head;

    }
}
