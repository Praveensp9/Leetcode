package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class LC332_ReconstructItenary {
	
	 	private static Map<String, PriorityQueue<String>> flights;
	    private static LinkedList<String> path;
	    
	    public static void dfs(String departure) {
	        PriorityQueue<String> arrivals = flights.get(departure);
	        while (arrivals != null && !arrivals.isEmpty())
	            dfs(arrivals.poll());
	        path.addFirst(departure);
	    }
	    
	    public static List<String> findItinerary(List<List<String>> tickets) {
	        
	        flights = new HashMap<>();
	        path = new LinkedList<>();
	        
	        for (List<String> ticket : tickets) {
	            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
	            flights.get(ticket.get(0)).add(ticket.get(1));
	        }
	        dfs("JFK");
	        return path;
	        
	    }

	public static void main(String[] args) {

		List<List<String>> tickets = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		temp.add("JFK");
		temp.add("BOS");
		
		tickets.add(Arrays.asList("JFK","SFO"));
		tickets.add(Arrays.asList("JFK","ATL"));
		tickets.add(Arrays.asList("SFO","ATL"));
		tickets.add(Arrays.asList("ATL","JFK"));
		tickets.add(Arrays.asList("ATL","SFO"));
		tickets.add(temp);
		
		List<String> path = findItinerary(tickets);
		for(String s:path)
			System.out.print(s+ " ");
	}

}
