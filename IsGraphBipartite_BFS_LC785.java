package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class IsGraphBipartite_BFS_LC785 {
	
	
	// Java BFS solution
    private boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)
            return true;
        int nodes  = graph.length;
        int[] color = new int[nodes];
        for(int i=0;i<nodes;i++){
            
            if(color[i] == 0){
                Queue<Integer> bfs = new LinkedList<>();
                bfs.add(i);
                color[i] = 1;
                while(!bfs.isEmpty()){
                        int temp = bfs.poll();

                        for(int neighbours : graph[temp]){

                            if(color[neighbours] !=0){
                                if(color[neighbours]+color[temp] !=0 )
                                    return false;
                            }
                            else{
                                color[neighbours] = -color[temp];
                                bfs.add(neighbours);
                            }
                        }
                    }
            }
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
