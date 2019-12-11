package leetcode;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
public class UnionFindForConnectedComponentsInaGraph_LC323 {
	
	 private static class UnionFind{
	        
	        private static int[] parent;
	        private static int[] rank;
	        private int cnt=0;
	        
	        public UnionFind(int n){
	            parent = new int[n];
	            rank = new int[n];
	            for(int i=0;i<n;i++){
	                parent[i] = i;
	                rank[i] = 1;
	            }
	            
	            cnt = n;
	        }
	        
	        private int find(int x){
	            if(parent[x] != x)
	                parent[x] = find(parent[x]);
	            return parent[x];
	        }
	        
	        public void union(int x,int y){
	            
	            int xp = find(x);
	            int yp = find(y);
	            
	            if(xp == yp)
	                return;
	            cnt--;
	            if(rank[xp] < rank[yp]){
	                parent[xp] = yp;
	                rank[yp]++;
	            }
	            else if(rank[xp] > rank[yp]){
	                parent[yp] = xp;
	                rank[xp]++;
	            }
	            else{
	                parent[yp] = xp;
	                rank[xp]++;
	            }
	        }
	        
	        public int getSize(){
	            return cnt;
	        }
	    }
	    
	    public int countComponents(int n, int[][] edges) {
	        
	        if (edges == null || edges.length == 0) {
	            return n;
	        }
	        
	        UnionFind uf = new UnionFind(n);
	        for(int[] edge:edges){
	            uf.union(edge[0],edge[1]);
	        }
	        
	        return uf.getSize();
	        
	    }

	public static void main(String[] args) {
		UnionFindForConnectedComponentsInaGraph_LC323 uf = new UnionFindForConnectedComponentsInaGraph_LC323();		
		
		int[][] edges = new int[][]{{0,1},{1,2},{3,4}};
		int connected = uf.countComponents(5,edges);
		System.out.println(connected);

	}

}
