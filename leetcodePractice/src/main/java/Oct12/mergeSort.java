package Oct12;

import java.util.*;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    curr.next = l1;
                    curr = curr.next;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    curr = curr.next;
                    l2 = l2.next;
                }
            } else if(l1 == null){
                curr.next = l2;
                return head.next;
            } else {
                curr.next = l1;
                return head.next;
            }
        }
        return head.next;
    }
}


class ListNode {
     int val;
     public ListNode next;
     ListNode(int x) { val = x; }
}