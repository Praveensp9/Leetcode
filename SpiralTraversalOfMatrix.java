package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {
	
	// Using concept of Neighbours traversal . TC : O(n) SC: O(n)
	private static List<Integer> spiralform(int[][] matrix){
		
		List<Integer> lst = new ArrayList<>();
        if(matrix.length == 0)
            return lst;
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row*col;
        boolean[][] visited = new boolean[row][col];
        
        int[] nr={0,1,0,-1};
        int[] nc={1,0,-1,0};
        
        int r=0;
        int c=0;
        int k=0;
        for(int i=0;i<n;i++){
            lst.add(matrix[r][c]);
            visited[r][c] = true;
            int tr = r + nr[k];
            int tc = c + nc[k];
            if(tr >=0 && tr < row && tc >=0 && tc<col && !visited[tr][tc]){
                r=tr;
                c=tc;
            }
            else{
                k=(k+1)%4;
                r = r + nr[k];
                c = c + nc[k];
            }
        }
        
        return lst;
		
	}
	
	// Another Solution 
	private static List<Integer> spiralform2(int[][] matrix){
		
		List<Integer> lst = new ArrayList<>();
        if(matrix.length == 0)
            return lst;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int r1=0;
        int c1=0;
        int r2=row-1;
        int c2=col-1;
        
        while(r1<=r2 && c1<=c2){
            
            for(int c=c1;c<=c2;c++)
                lst.add(matrix[r1][c]);
            for(int r=r1+1;r<=r2;r++)
                lst.add(matrix[r][c2]);
            
            if(r1<r2 &&  c1<c2){
                
                for(int c=c2-1;c>c1;c--)
                    lst.add(matrix[r2][c]);
                
                for(int r=r2;r>r1;r--)
                    lst.add(matrix[r][c1]);
            }
            
            r1++;
            c1++;
            r2--;
            c2--;
        }
        
        return lst;
		
	}

	public static void main(String[] args) {
		
		int[][] matrix = new int[][] {
			 {1,2,3,4,5},
			 {6,7,8,9,10},
			 {11,12,13,14,23},
			 {15,16,17,18,24},
			 {19,20,21,22,25}};
			 
		List<Integer> res = spiralform(matrix);
		

	}

}
