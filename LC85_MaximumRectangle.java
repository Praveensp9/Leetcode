package leetcode;

import leetcode.LC84_LargestAreaInAHistogram;

public class LC85_MaximumRectangle {
	
	private static int maximumRectange(int[][] matrix) {
		  if(matrix.length == 0 || matrix == null)
	            return 0;
	        
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int max = 0;
	        int[] temp = new int[m]; 
	        for(int i=0;i<m;i++){
	            for(int j =0;j<n;j++){
	                if(matrix[i][j] == 0)
	                    temp[j] = 0;
	                else
	                    temp[j] += matrix[i][j];
	            }
	            
	             for(int k:temp)
	                 System.out.print(k+" ");
	             System.out.println();
	            LC84_LargestAreaInAHistogram lc = new LC84_LargestAreaInAHistogram();
	            int area = lc.largestRectangleArea(temp);
	             System.out.println(area);
	            if(max<area)
	                max = area;
	        }
	        return max;
	}

	public static void main(String[] args) {
		
		 int[][] input = new int[][]{{1,1,1,0},
                 {1,1,1,1},
                 {0,1,1,0},
                 {0,1,1,1},
                 {1,0,0,1},
                 {1,1,1,1}};
		 int ans = maximumRectange(input);
		 System.out.print(ans);
	}

}
