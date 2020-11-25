package man.kuke.core;

import java.util.HashMap;
public class LRUCache {
    private  HashMap<Integer, DoublelyLinkedNode> map;
    private  DoublelyLinkedNode head;
    private  DoublelyLinkedNode tail;
    private int capacity;
    private int size;

    {
        map = new HashMap<>();
        head = new DoublelyLinkedNode(-1,-1);
        tail = new DoublelyLinkedNode(-1,-1);
        head.next = tail;
        tail.pre = head;
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void update(int key,int val) {
        DoublelyLinkedNode newNode = new DoublelyLinkedNode(key,val);
        remove(key);
        append(newNode);
    }

    public int get(int key) {
        DoublelyLinkedNode node = map.get(key);
        if (node == null) {
            return -1;
        }

        update(key,node.val);
        return node.val;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            update(key,value);
            return;
        }

        if (isFull()) {
            remove(head.next.key);
        }

        update(key, value);
    }

    public void remove(int key) {
        DoublelyLinkedNode node =  map.remove(key);
        if (node == null) {
            return;
        }

        node.pre.next = node.next;
        node.next.pre = node.pre;
        --size;
    }

    public void append(DoublelyLinkedNode node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        map.put(node.key, node);
        ++size;
    }

    private static class DoublelyLinkedNode {
        DoublelyLinkedNode pre;
        DoublelyLinkedNode next;
        int val;
        int key;

        public DoublelyLinkedNode(int key,int val) {
            this.val = val;
            this.key = key;
        }

    }
}