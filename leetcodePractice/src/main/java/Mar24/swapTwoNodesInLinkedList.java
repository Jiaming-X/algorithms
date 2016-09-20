package Mar24;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class swapTwoNodesInLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode curr = new ListNode(2);
		head.next = curr;
		curr.next = new ListNode(3);
		curr = curr.next;
		curr.next = new ListNode(4);
		curr = curr.next;
		head = swapNodes(head, 2, 4);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

    static public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode p1 = null, p2 = null, curr = newHead;
        
        while (curr.next != null) {
            if (p1 != null && p2 != null) {
                break;
            }
            if (p1 == null && curr.next.val == v1) {
                p1 = curr;
            } else if (p2 == null && curr.next.val == v2) {
                p2 = curr;
            }
            curr = curr.next;
        }
        if (p1 == null || p2 == null) {
            return newHead.next;
        }
        ListNode copy = p1.next;
        p1.next = p2.next;
        p2.next = copy;
        
        copy = p1.next.next;
        p1.next.next = p2.next.next;
        p2.next.next = copy;
        return newHead.next;
    }
}
