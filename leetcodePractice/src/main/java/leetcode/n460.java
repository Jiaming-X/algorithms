package leetcode;

import java.util.*;

public class n460 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        LFUCache cache = new LFUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.set(3, 3);    // evicts key 2
        
        System.out.println(cache.nodeMap.keySet());
        
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.set(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}


class LFUCache {
    // head
    class Node {
        int count;
        Node pre;
        Node next;
        LinkedHashSet<Integer> keys;
        
        public Node (int count) {
            this.count = count;
            this.pre = null;
            this.next = null;
            keys = new LinkedHashSet<Integer>();
        }
    }
    
    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Node> nodeMap;
    Node head;
    int cap;

    public LFUCache(int capacity) {
        valueMap = new HashMap<Integer, Integer>();
        nodeMap = new HashMap<Integer, Node>();
        head = new Node(0);
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        increase(key);
        return valueMap.get(key);
    }
    
    public void set(int key, int value) {
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            increase(key);
        } else {
            if (valueMap.size() < cap) {
                valueMap.put(key, value);
                insertInHead(key);
                increase(key);
            } else {
                int valToDelete = 0;
                
                for (Integer num : head.next.keys) {
                    valToDelete = num;
                    break;
                }
                valueMap.remove(valToDelete);
                nodeMap.get(valToDelete).keys.remove(valToDelete);
                nodeMap.remove(valToDelete);
                
                valueMap.put(key, value);
                insertInHead(key);
                increase(key);
            }
        }
    }
    
    private void insertInHead (int key) {
        if (head.next == null) {
            Node newNode = new Node(1);
            newNode.keys.add(key);
            nodeMap.put(key, newNode);
            
            newNode.pre = head;
            head.next = newNode;
        } else if (head.next.count == 1){
            head.next.keys.add(key);
            nodeMap.put(key, head.next);
        } else {
            Node nextNode = head.next;
            
            Node newNode = new Node(1);
            newNode.keys.add(key);
            nodeMap.put(key, newNode);
            
            newNode.pre = head;
            head.next = newNode;
            
            newNode.next = nextNode;
            nextNode.pre = newNode;
        }
    }
    
    // increase frequencey, and adjust the linkedHashSet
    private void increase(int key) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        
        if (node.next == null) {
            Node newNode = new Node(node.count + 1);
            newNode.keys.add(key);
            node.next = newNode;
            newNode.pre = node;
            nodeMap.put(key, newNode);
        } else if (node.count + 1 == node.next.count) {
            node.next.keys.add(key);
            nodeMap.put(key, node.next);
        } else {
            Node nextNode = node.next;
            
            Node newNode = new Node(node.count + 1);
            newNode.keys.add(key);
            nodeMap.put(key, newNode);
            
            node.next = newNode;
            newNode.pre = node;
            newNode.next = nextNode;
            nextNode.pre = newNode;
        }
        if (node.keys.size() == 0) {
            remove(node);
        }
    }
    
    private void remove(Node node) {
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }
}