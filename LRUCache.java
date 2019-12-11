package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private class ListNode{
		int key;
		int val;
		ListNode prev;
		ListNode next;
	}
	
	Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
	ListNode head;
	ListNode tail;
	int totalItemsinCache;
	int maxCapacity;
	
	public LRUCache(int capacity) {
		totalItemsinCache = 0;
		this.maxCapacity = capacity;
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.prev = head;
	}
	
	public void addToFront(ListNode node) {
		node.prev = head;
		node.next = head.next;
		head.next.prev = node;
		head.next = node;
	}
	
	public void removeFromList(ListNode node) {
		ListNode prev= node.prev;
		ListNode next= node.next;
		prev.next = next;
		next.prev = prev;
	}
	
	public void moveToHead(ListNode node) {
		removeFromList(node);
        addToFront(node);
	}
	
	public ListNode popTail() {
		ListNode last = tail.prev;
		removeFromList(last);
		return last;
	}
	public void removeLruEntry() {
		ListNode tail = popTail();
		map.remove(tail.key);
		totalItemsinCache--;
	}
	
	public void put(int key,int value) {
		ListNode node = map.get(key);
		if(node == null) {
			ListNode new_node = new ListNode();
			new_node.key = key;
			new_node.val = value;
			
			map.put(key,new_node);
			addToFront(new_node);
			totalItemsinCache++;
			
			if(totalItemsinCache > maxCapacity) {
				removeLruEntry();
			}
		}
		else {
			node.val = value;
			moveToHead(node);
		}
	}
	
	public int get(int key) {
		ListNode node = map.get(key);
		if(node == null) {
			return -1;
		}
		moveToHead(node);
		return node.val;
	}

	public static void main(String[] args) {
		
		int val =0;
		LRUCache cache = new LRUCache(2);
		cache.put(1, 10);
		cache.put(2, 20);
		
		val = cache.get(1);
		System.out.println(val);
		
		cache.put(3, 30);
		
		val = cache.get(2);
		System.out.println(val);
		
		cache.put(4, 40);
		
		val = cache.get(1);
		System.out.println(val);
		
		val = cache.get(3);
		System.out.println(val);
		
		val = cache.get(4);
		System.out.println(val);

	}

}
