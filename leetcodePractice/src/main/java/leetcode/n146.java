package leetcode;

import java.util.HashMap;
import java.util.List;

public class n146 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRUCache soln = new LRUCache(1);
        soln.set(2,1);
        System.out.println(soln.get(2));
        soln.set(3,2);
        soln.printOutAll();
        System.out.println(soln.get(3));
        //System.out.println(soln.get(2));
        soln.get(3);
    }

}

class LRUCache {
    private class ListNode {
        ListNode prev;
        ListNode next;
        int key;
        int val;
        
        public ListNode (int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }
    
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;
    int size;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, ListNode>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.capacity = capacity;
        this.size = 0;
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
            moveToTail(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            moveToTail(node);
        } else if (this.size < this.capacity){
            this.size++;
            ListNode newEle = new ListNode(key, value);
            map.put(key, newEle);
            moveToTail(newEle);
        } else {
            ListNode node = this.head.next;
            remove(node);
            map.remove(node.key);
//            System.out.println(this.head.next.key);
//            System.out.println(this.head.next.val);

            ListNode newEle = new ListNode(key, value);
            map.put(key, newEle);
            moveToTail(newEle);
        }
    }
    
    public void remove(ListNode node) {
        // remove
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
    
    public void moveToTail (ListNode node) {
        // append to the tail
        node.prev = this.tail.prev;
        node.prev.next = node;
        node.next = this.tail;
        this.tail.prev = node;
    }
    
    public void printOutAll(){
        ListNode curr = this.head;
        while (curr != null) {
            System.out.print(curr.key);
            System.out.print(" ");
            System.out.print(curr.val);
            System.out.println();
            curr = curr.next;
        }
    }
}