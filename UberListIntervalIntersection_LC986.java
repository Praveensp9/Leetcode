package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UberListIntervalIntersection_LC986 {

	
	private static int[][] intervalIntersection(int[][] A,int[][] B){
	    
//		Arrays.sort(A, (int[] o1, int[] o2) -> o1[0] - o2[0]);
//        Arrays.sort(B, (int[] o1, int[] o2) -> o1[0] - o2[0]);
		
		Arrays.sort(A, new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int[] y){
                return Integer.compare(x[0],y[0]);
            }
        });
         Arrays.sort(B, new Comparator<int[]>(){
            @Override
            public int compare(int[] x, int[] y){
               return Integer.compare(x[0],y[0]);
            }
        });
        
        
        System.out.println(Arrays.deepToString(A));
        
        System.out.println(Arrays.deepToString(B));
        
        System.out.println();
		
		
		List<int[]> res = new ArrayList<>();
		int i=0,j=0,m=A.length,n=B.length;
		
		while(i<m && j<n) {
			
			int low = Math.max(A[i][0], B[j][0]);
			int high = Math.min(A[i][1], B[j][1]);
			
			if(low<=high)
				res.add(new int[] {low,high});
			
			
			
			if(A[i][1] < B[j][1])
				i++;
			else
				j++;
		}
		
		return res.toArray(new int[res.size()][]);
	}
	
	public static void main(String[] args) {
//		int[][] A = {{0,2},{5,10},{13,23},{24,25}};
//		int[][] B = {{1,5},{8,12},{15,24},{25,26}};
		
		int[][] A = {{2,4},{6,8},{1,3}};
		int[][] B = {{7,9},{2,5}};
		int[][] arr = intervalIntersection(A,B);
		for(int[] ans:arr)
			System.out.print(ans[0]+","+ans[1] + "  ");
	}

}
