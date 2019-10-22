package leetcode;

import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class UberRateLimiter {
	
	
	    public static class RateLimiter {
	        private final int REQUEST_LIMIT = 3;
	        private final long TIME_LIMIT = 1000L; // 1000L -> 10 seconds, 1000 -> 1 second
	    	
	        public class HitCounter {
	        	
	            Queue<Long> q = null;
	            public HitCounter() {
	                q = new LinkedList<Long>();
	            }

	            public boolean hit(long timestamp) {
	                while(!q.isEmpty() && timestamp-q.peek() >= TIME_LIMIT)
	                	q.poll();
	                
	                if(q.size() < REQUEST_LIMIT)
	                {
	                    q.offer(timestamp); 
	                    return true;
	                }
	                
	                return false;
	            }
	        }
	        
	        private final Map<String, HitCounter> clientHitMap = new HashMap<String, HitCounter>();
	        
	        public boolean isAllow(String client_id) {
	            HitCounter h = clientHitMap.get(client_id);
	            
	            long curTime = System.currentTimeMillis();
	            
	            if(h == null) {
	                h = new HitCounter();
	                clientHitMap.put(client_id, h);
	            } 
	            
	            return h.hit(curTime);
	        }        
	    }    
	    
	    public static void main(String[] args) {
	    	
	    	
	        RateLimiter limiter = new RateLimiter();
	        System.out.println("Client1 " + limiter.isAllow("Client1"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        System.out.println("Sleeping for 1 second");
	        try {
	            java.lang.Thread.sleep(1000); 
	        } catch (InterruptedException ex) {
	            System.out.println(ex);
	        }
	        System.out.println("Client1 " + limiter.isAllow("Client1"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	        
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client2 " +limiter.isAllow("Client2"));
	        System.out.println("Client1 " +limiter.isAllow("Client1"));
	    }
	    
	    
	

}
