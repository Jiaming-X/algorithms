package leetcode;

public class n92 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ReverseLinkedList soln = new ReverseLinkedList();
        ListNode node = new ListNode(3);
        node.next = new ListNode(5);
        node.next.next = new ListNode(8);
        soln.reverseBetween(node, 1, 3);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class ReverseLinkedList {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode current = pre.next;
        ListNode next = current.next;

        for (int i = 0; i < n - m; i++) {
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = current.next;

            System.out.println();
            System.out.println(dummy.val);
            System.out.println(dummy.next.val);
            System.out.println(dummy.next.next.val);
            System.out.println(dummy.next.next.next.val);
        }

        System.out.println();
        System.out.println(dummy.val);
        System.out.println(dummy.next.val);
        System.out.println(dummy.next.next.val);
        return dummy.next;
    }
}