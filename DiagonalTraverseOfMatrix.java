package leetcode;

public class DiagonalTraverseOfMatrix {
	
	private static int[] traverse(int[][] matrix) {
		int r= matrix.length;
		int c=matrix[0].length;
		int n = r*c;
		int[] arr = new int[n];
		
		int t = 0;
		int l = 0;
		int i = 0;
		
		while(i<n) {
			
			while(t>=0 && l<c) {
				arr[i++] = matrix[t][l];
				t--;
				l++;
			}
			
			if(l>=c) {
				l--;
				t=t+2;
			}
			else if(t<0)
				t++;
			
			while(t<r && l>=0) {
				arr[i++] = matrix[t][l];
				t++;
				l--;
			}
			
			if(t>=r) {
				t--;
				l=l+2;
			}
			else if(l<0)
				l++;

		}
		return arr;
		
	}
	public static void main(String[] args) {
		
		int[][] matrix = new int[][] {
							            {1,2,6,5},
							            {4,5,3,6},
							            {7,8,9,0}
										  };


		int[] res = traverse(matrix);
		for(int i:res)
			System.out.print(i+" ");
	}

}
