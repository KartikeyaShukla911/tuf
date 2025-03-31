package com.tuf.cache;

public class LRUcache {

	class LRUCacheCustom {
	    private class Node {
	        int key, value;
	        Node prev, next;
	        Node(int k, int v) { key = k; value = v; }
	    }

	    private final int capacity;
	    private final Map<Integer, Node> cache;
	    private final Node head, tail;

	    public LRUCacheCustom(int capacity) {
	        this.capacity = capacity;
	        this.cache = new HashMap<>();

	        // Dummy head & tail to avoid null checks
	        head = new Node(0, 0);
	        tail = new Node(0, 0);
	        head.next = tail;
	        tail.prev = head;
	    }

	    /*
	     * Doubly Linked List + HashMap	O(1)	O(N)	✅ Fully Customizable
	     */
	    public int get(int key) {
	        if (!cache.containsKey(key)) return -1;

	        Node node = cache.get(key);
	        moveToHead(node); // Move accessed node to front
	        return node.value;
	    }

	    public void put(int key, int value) {
	        if (cache.containsKey(key)) {
	            // Update existing node
	            Node node = cache.get(key);
	            node.value = value;
	            moveToHead(node);
	        } else {
	            // Insert new node
	            Node newNode = new Node(key, value);
	            cache.put(key, newNode);
	            addToHead(newNode);

	            if (cache.size() > capacity) {
	                removeLRU();
	            }
	        }
	    }

	    private void moveToHead(Node node) {
	        removeNode(node);
	        addToHead(node);
	    }

	    private void addToHead(Node node) {
	        node.next = head.next;
	        node.prev = head;
	        head.next.prev = node;
	        head.next = node;
	    }

	    private void removeNode(Node node) {
	        node.prev.next = node.next;
	        node.next.prev = node.prev;
	    }

	    private void removeLRU() {
	        Node lru = tail.prev;
	        removeNode(lru);
	        cache.remove(lru.key);
	    }

	    public static void main(String[] args) {
	        LRUCacheCustom cache = new LRUCacheCustom(2);
	        cache.put(1, 1);
	        cache.put(2, 2);
	        System.out.println(cache.get(1)); // Output: 1
	        cache.put(3, 3); // Removes key 2 (least recently used)
	        System.out.println(cache.get(2)); // Output: -1
	    }
	}
}
