package leetcode;

public class RotateAMatrixClockWise90 {
	
	private static void rotate2(int[][] matrix) {
		int n = matrix.length;
        if(n==0) return;
        int i = 0, j = n-1;
        while(i<=j){
            int l = i, u = i;
            int r = j, d = j;
            while(l<j){
                int tmp = matrix[i][l];
                matrix[i][l] = matrix[d][i];
                matrix[d][i] = matrix[j][r];
                matrix[j][r] = matrix[u][j];
                matrix[u][j] = tmp;
                l++;r--;u++;d--;
            }
            i++;
            j--;
        }
	}
	
	
	// My Solution of tranpose matrix
	private static void rotate1(int[][] matrix) {
		
		int rows = matrix.length;
		
		for(int i=0;i<rows;i++) {
			for(int j=i;j<matrix.length;j++) {
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<rows/2;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][rows-1-j];
				matrix[i][rows-1-j] = temp;
			}
		}
		
	}
	
	private static void print(int[][] matrix) {
		int rows = matrix.length;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<rows;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	

	public static void main(String[] args) {
	
		int[][] matrix = new int[][] {
		                               {1,2,6,5},
		                               {4,5,3,6},
		                               {7,8,9,0}
									  };

		rotate1(matrix);
		print(matrix);
		System.out.println("\n");
		//rotate2(matrix);
		//print(matrix);
	}

}
