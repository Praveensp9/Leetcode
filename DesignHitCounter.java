package leetcode;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	private static void printHits(int time, int hits) {
		System.out.println("The number of hits before 5 mins from the timestamp -> " + time + " : "+hits);
	}

	public static void main(String[] args) {
		
		DesignHitCounter counter = new DesignHitCounter();
		
		counter.hits(1);
		counter.hits(2);
		counter.hits(3);
		counter.hits(4);
		counter.hits(381);
		int hits = counter.getHits(623);
		printHits(4,hits);
		

	}

}
