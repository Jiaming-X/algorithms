package class10_recursionII;


class ListNode {
   public int value;
   public ListNode next;
   public ListNode(int value) {
     this.value = value;
     next = null;
   }
}

public class reverseInPair {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here.
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode nextList = reverseInPairs(head.next.next);
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = nextList;
        
        return newHead;
    }
}
