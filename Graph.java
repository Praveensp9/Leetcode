package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import java.util.Iterator;

public class Graph {
	
	// Vertices
	private int v;
	
	//Adjancency List
	private ArrayList<Integer>[] adjList;
	
	List<List<Integer>> res = new ArrayList<>();
	
	//Constructor
	public Graph(int vertices){
		this.v = vertices;
		adjList = new ArrayList[v];
		for(int i=0;i<v;i++)
			adjList[i] = new ArrayList<>();
	}
	
	public void addEdge(int u,int v) {
		adjList[u].add(v);
	}
	
	public void printAllPaths(int s,int d) {
		boolean[] isVisited = new boolean[v];
		ArrayList<Integer> paths = new ArrayList<>();
		paths.add(s);
		printAllPathsUtil(s,d,isVisited,paths);
	}
	
	private void printAllPathsUtil(Integer u,Integer v,boolean[] isVisited,List<Integer> paths) {
		isVisited[u] = true;
		if(u.equals(v)) {
			System.out.println(paths);
			res.add(paths);
			isVisited[u] = false;
			return;
		}
		
		for(Integer i: adjList[u]) {
			if(!isVisited[i]) {
				paths.add(i);
				printAllPathsUtil(i,v,isVisited,paths);
				paths.remove(i);
			}
		}
		isVisited[u] = false;
	}
	
	private void topologicalSortUtil(int vertex, boolean[] visited,Stack stk) {
		visited[vertex] = true;
		int i=0;
		Iterator<Integer> it = adjList[vertex].iterator();
		while(it.hasNext()) {
			i = it.next();
			if(!visited[i])
				topologicalSortUtil(i,visited,stk);
			
		}
		stk.push(vertex);

	}
	
	public List<Integer> topologicalSort() {
		Stack<Integer> stk = new Stack<>();
		
		boolean[] visited = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if(!visited[i]) {
				topologicalSortUtil(i,visited,stk);
			}
		}
		
		List<Integer> res= new ArrayList<>();
		while(!stk.isEmpty())
			res.add(stk.pop());
		return res;
	}
	private boolean isCyclicUtil(int i, boolean[] visited,boolean[] recStack)  
	{ 
	
		// Mark the current node as visited and 
		// part of recursion stack 
		if (recStack[i]) 
		return true; 
		
		if (visited[i]) 
		return false; 
		
		visited[i] = true; 
		
		recStack[i] = true; 
		List<Integer> children = adjList[i]; 
		
		for (Integer c: children) 
		if (isCyclicUtil(c, visited, recStack)) 
		return true; 
		
		recStack[i] = false; 
		
		return false; 
	} 
	public boolean isCyclic(){
		 boolean[] visited = new boolean[v]; 
	        boolean[] recStack = new boolean[v]; 
	          
	          
	        // Call the recursive helper function to 
	        // detect cycle in different DFS trees 
	        for (int i = 0; i < v; i++) 
	            if (isCyclicUtil(i, visited, recStack)) 
	                return true; 
	  
	        return false; 
	}

	public static void main(String[] args) {
		
		Graph g = new Graph(6);
		g.addEdge(5,0);
		g.addEdge(4,0);
		g.addEdge(5,2);
		g.addEdge(3,1);
		g.addEdge(2,3);
		g.addEdge(4,1);
		
		int s = 2,d=3;
		System.out.println("All paths from "+s+" to "+d);
		g.printAllPaths(s, d);
		
		
		Graph g1 = new Graph(4);
		g1.addEdge(3,1);
		g1.addEdge(1,0);
		g1.addEdge(2,0);
		g1.addEdge(3,2);
		System.out.println("Following is a Topological sort of the given graph");
		List<Integer> res = g1.topologicalSort();
		Collections.reverse(res);
		for(int i:res)
			System.out.print(i+" ");
		
		System.out.println();
		Graph g2 = new Graph(4);
		g2.addEdge(0,1);
		g2.addEdge(1,0);
		g2.addEdge(2,0);
		g2.addEdge(3,2);
		
		boolean cycle = g2.isCyclic();
		
		if(cycle) {
			System.out.println("Cycle Detected");
		}
		else {
			System.out.println("Following is a Topological sort of the given graph");
			List<Integer> res2 = g2.topologicalSort();
			Collections.reverse(res2);
			for(int i:res2)
				System.out.print(i+" ");
		}
	}

}
