package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DesignHitCounter {
	private  static List<Integer> hits = new ArrayList<Integer>();
	
	
	/* 
	 * Record a hit.
	 * @param timestamp - The current timestamp (in seconds granularity). 
     */
	private void hits(int time) {
		hits.add(time);
		
	}
	
	/* 
	 * Return the number of hits in the past 5 minutes.
	 * @param timestamp - The current timestamp (in seconds granularity). 
	*/
	private  int getHits(int timestamp) {
		
		int i;
		for(i=0;i<hits.size();i++) {
			
			if(hits.get(i) > (timestamp - 300) )
				break;
		}
		return hits.size() - i;
	
	}
	
	Queue<Integer> q = new LinkedList<>();
	private  void hitsq(int t) {
		q.add(t);
	}
	
	private int getHitsq(int t) {
		while(!q.isEmpty() && (t-q.peek() >=300)){
			q.remove();
		}
		return q.size();
	}
	
	
	
	private static void printHits(int time, int hits) {
		System.out.println("The number of hits before 5 mins from the timestamp -> " + time + " : "+hits);
	}

	public static void main(String[] args) {
		
		DesignHitCounter counter = new DesignHitCounter();
		
		counter.hits(1);
		counter.hits(2);
		counter.hits(3);
		counter.hits(4);
		counter.hits(301);
		int hits = counter.getHits(301);
		printHits(301,hits);
		
		counter.hitsq(1);
		counter.hitsq(2);
		counter.hitsq(3);
		counter.hitsq(4);
		counter.hitsq(301);
		int h = counter.getHitsq(301);
		printHits(301,h);
		

	}

}
