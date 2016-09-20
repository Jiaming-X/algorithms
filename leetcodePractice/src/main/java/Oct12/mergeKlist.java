package Oct12;

import java.util.*;

public class mergeKlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        if(lists.length == 1){
            return lists[0];
        }
        
        		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
				
        for(ListNode oneNode : lists){
            if(oneNode != null){
                queue.add(oneNode);
            }
        }
        ListNode aNode = new ListNode(-1);
        ListNode p = aNode;
        
        while(queue.size() > 0){
            ListNode currNode = queue.poll();
            p.next = currNode;
            p = p.next;
            if(currNode.next != null){
                queue.add(currNode.next);
            }
        }
        return aNode.next;
    }
}
