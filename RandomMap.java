package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/* class RandomMap {
		void put(int key, int value);
		Integer get(int key);
		Integer getRandom(); // this should return a random value with equal probability 
		void remove(int key);
} */


public class RandomMap {
	
	private static class Entry{
		int key;
		int value;
		public Entry(int k,int v) {
			this.key = k;
			this.value = v;
		}
	}
	
	private Map<Integer,Integer> keyToIndex = new HashMap<>();
	private List<Entry> entries = new ArrayList<>();
	
	public void put(int k,int v) {
		if(keyToIndex.containsKey(k)) {
			Entry entry = entries.get(keyToIndex.get(k));
			entry.value = v;
		}
		else {
			keyToIndex.put(k,entries.size());
			entries.add(new Entry(k,v));
		}
	}
	
	public Integer get(int k) {
		Integer at = keyToIndex.get(k);
        return at != null ? entries.get(at).value : null;
	
	}
	
	public void remove(int k) {
		if(entries.isEmpty() || !keyToIndex.containsKey(k))
			return;
		int curr = keyToIndex.get(k);
        int last = entries.size() - 1;

        if (curr != last) {
            Collections.swap(entries, curr, last);
            Entry entry = entries.get(curr);
            keyToIndex.replace(entry.key, curr);
        }

        entries.remove(last); // remove last element O(1)
        keyToIndex.remove(k);
	}
	
	public Integer getRandom() {
		if (entries.isEmpty())
			return null;
		 int at = ThreadLocalRandom.current().nextInt(entries.size());
		 return entries.get(at).value;
	}
	
	private static Integer random() {
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(9,100);
		map.put(12,15);
		map.put(10,23);
		map.put(0,5);
		
		int at = ThreadLocalRandom.current().nextInt(map.size());
		System.out.println(at);
		return map.get(at);
	}
	public static void main(String[] args) {
		
		RandomMap map = new RandomMap();
		map.put(9, 100);
		map.put(0, 1);
		map.put(12, 15);
		map.put(9, 20);
		map.put(10, 23);
		map.put(0, 5);
		
		System.out.println(map.get(12));
		System.out.println(map.get(9));
		System.out.println(map.get(10));
		System.out.println(map.get(0));
		
		map.remove(9);
		
		System.out.println(map.get(9));
		
		map.put(9, 100);
		
		System.out.println(map.get(9));
		
		System.out.println(map.getRandom());
		
		System.out.println();
		System.out.println(random());
		
	}
}
