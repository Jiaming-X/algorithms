package class26;

import java.util.HashMap;

public class LRUcache<K, V> {
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;
        
        public Node (K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public void update (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int limit;
    private Node<K, V> head;
    private Node<K, V> tail;
    public HashMap<K, Node<K, V>> map = new HashMap<K, Node<K, V>>();
    
    public LRUcache(int limit) {
        this.limit = limit;
    }
    
    public void set(K key, V value) {
      Node<K, V> node = null;  
        
      if (map.containsKey(key)) {
          node = map.get(key);
          node.value = value;
          remove(node);
      } else if (map.size() < this.limit) {
          node = new Node<K, V>(key, value);
      } else {
          node = this.tail;
          remove(tail);
          node.update(key, value);
      }
      append(node);
    }
    
    public void append(Node<K, V> node) {
        map.put(node.key, node);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    public Node<K, V> remove(Node<K, V> node){
        map.remove(node.key);
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (this.tail == node) {
            this.tail = this.tail.prev;
        }
        if (this.head == node) {
            this.head = this.head.next;
        }
        node.prev = node.next = null;
        return node;
    }
    
    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        } else {
            remove(node);
            append(node);
            return node.value;
        }
    }
}
