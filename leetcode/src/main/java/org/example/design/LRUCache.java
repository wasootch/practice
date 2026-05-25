package org.example.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    Node head = new Node();
    Node tail = new Node();

    int capacity;
    Map<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        cache.put(key, node);
        insert(node);

        if (cache.size() > capacity) {
            Node last = tail.prev;
            remove(last);
            cache.remove(last.key);
        }
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
