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
			
			int index = 0;
			int i = 0;
			Iterator<Integer> itr = lru.iterator();
			
			while(itr.hasNext()) {
				if(itr.next() == x) {
					index = i;
					break;
				}
				i++;
			}
			lru.remove(index);
			
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
		LRUCacheDesign lru = new LRUCacheDesign(3);
		lru.pageFaults(1);
		lru.display();
		lru.pageFaults(2);
		lru.display();
		lru.pageFaults(3);
		lru.display();
		lru.pageFaults(6);
		lru.display();
		lru.pageFaults(3);
		lru.display();
		lru.pageFaults(5);
		lru.display();
		
	}

}
