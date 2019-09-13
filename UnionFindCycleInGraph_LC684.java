package leetcode;

public class UnionFindCycleInGraph_LC684 {
	
	private static class UnionFind {
		private static int[] parent;
		private static int[] rank;
		
		public UnionFind(int n) {
			parent= new int[n];
			for(int i=0;i<n;i++)
				parent[i] = i;
			rank = new int[n];
		}
		
		
		private  int find(int x) {
			if(parent[x] != x)
				parent[x] = find(parent[x]);
			return parent[x];
		}
		
		private  boolean Union(int x,int y) {
			int xp = find(x);
			int yp = find(y);
			
			if(xp == yp)
				return false;
			
			else if(rank[xp] < rank[yp])
				parent[xp] = yp;
			else if(rank[xp] > rank[yp])
				parent[yp] = xp;
			else
			{
				parent[yp] = xp;
				rank[xp]++;
			}
			return true;
				
		}
		
		
	}

	
	// Using DFS Method
	private  void CycleInTreeDFS() {
		
	}
	
	// Using Union Find Method
	private static int[] CycleInTreeUF(int[][] edges) {
		
		UnionFind uf = new UnionFind(edges.length+1);
		for(int[] edge:edges) {
			if(!uf.Union(edge[0], edge[1]))
				return edge;
		}
	
		return new int[] {-1,-1};
	}
	
	public static void main(String[] args) {
		
		int[][] edges = new int[][] {{1,2},{1,3},{2,3}};
		
		int[] edge = CycleInTreeUF(edges);
		System.out.println(edge[0] + " , " + edge[1]);
			

	}

}
