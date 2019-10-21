package leetcode;

import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;

public class UberRateLimiter {
	
	
	private static class HitCounter {
		
		public Queue<Long> q;
		public HitCounter() {
			q = new LinkedList<>();
		}
		
		public boolean hit(long timestamp) {
			
			while(!q.isEmpty() && (timestamp - q.peek())>=3)
				q.poll();
			
			if(q.size() < 5) {
				q.add(timestamp);
				return true;
			}
			return false;
		}
	}
	
	public static HashMap<String,HitCounter> map = new HashMap<>();
	public static boolean isAllow(String id) {
		
		long curTime = System.currentTimeMillis();
		
		if(!map.containsKey(id)) {
			HitCounter h = new HitCounter();
			h.hit(curTime);
			return true;
		}
		else {
			HitCounter h = map.get(id);
			return h.hit(curTime);
		}
	}
	public static void main(String[] args) {
		
		System.out.println(isAllow("1"));
		System.out.println(isAllow("2"));
		System.out.println(isAllow("3"));
		System.out.println(isAllow("4"));
		System.out.println(isAllow("5"));
		System.out.println(isAllow("6"));
		System.out.println(isAllow("1"));
		System.out.println(isAllow("1"));
		System.out.println(isAllow("1"));
		System.out.println(isAllow("1"));
		System.out.println(isAllow("1"));
		System.out.println(isAllow("1"));
		System.out.println(isAllow("1"));
	}

}


































/*
 
 import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
	public int REQUEST_LIMIT = 100; 
	public Long TIME_LIMIT = 1000L; 
	public class HitCounter {
		public Queue<Long> queue;
		public HitCounter() {
			queue = new LinkedList<>();	
		}
		public boolean hit(long timestamp) {

			while (!queue.isEmpty() && queue.peek() - timestamp >= TIME_LIMIT) queue.poll();
			if (queue.size() < 500) {
				queue.add(timestamp); return true;
			}
			return false;
		}
	}
	public HashMap<String, HitCounter> clientTimeStampMap = new HashMap<>();
	public boolean isAllow(String clientId) {
		long currTime = System.currentTimeMillis();
		if (!clientTimeStampMap.containsKey(clientId)) {
			HitCounter h = new HitCounter();
			h.hit(currTime); return true;
		} else {
			HitCounter h = clientTimeStampMap.get(clientId);
			return h.hit(currTime);
		}
	}
	
}*/
