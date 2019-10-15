package leetcode;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCacheDesign {
	
	// Stores the keys of cache
	private static Deque<Integer> lru;
	
	// Stores the references of key in cache
	private static HashSet<Integer> set;
	
	// Size of the cache
	private static int n;
	
	private LRUCacheDesign(int n) {
		lru = new LinkedList<>();
		set = new HashSet<>();
		this.n = n;
	}
	
	// Refer to the key X in cache
	private  void pageFaults(int x) {
		
		if(!set.contains(x)) {
			if(lru.size() == this.n) {
				int last = lru.removeLast();
				set.remove(last);
			}
		}
		else {
			
			lru.remove(x);
			set.remove(x);			
			
		}
		
		lru.push(x);
		set.add(x);
		
	}
	
	// display contents of cache 
    public void display() 
    { 
        Iterator<Integer> itr = lru.iterator(); 
        while (itr.hasNext()) { 
            System.out.print(itr.next() + " "); 
        } 
        System.out.println();
    } 
	

	public static void main(String[] args) {
		LRUCacheDesign cache = new LRUCacheDesign(4);
		cache.pageFaults(1);
		cache.display();
		cache.pageFaults(2);
		cache.display();
		cache.pageFaults(4);
		cache.display();
		cache.pageFaults(6);
		cache.display();
		cache.pageFaults(4);
		cache.display();
		cache.pageFaults(5);
		cache.display();
		cache.pageFaults(5);
		cache.display();
		cache.pageFaults(7);
		cache.display();
		cache.pageFaults(5);
		cache.display();
		
	}

}
