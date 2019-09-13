package leetcode;

public class SubSetSumProblem {
	
	// Time complexity - O(input.size * total_sum)
	// Space complexity - O(input.size*total_sum)
	private static boolean subSetSum(int[] input,int total) {
		
		 boolean T[][] = new boolean[input.length + 1][total + 1];
	        for (int i = 0; i <= input.length; i++) {
	            T[i][0] = true;
	        }

	        for (int i = 1; i <= input.length; i++) {
	            for (int j = 1; j <= total; j++) {
	                if (j - input[i - 1] >= 0) {
	                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
	                } else {
	                    T[i][j] = T[i-1][j];
	                }
	            }
	        }
	        return T[input.length][total];
	}
	
	private static int partition(int[] arr) {
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = {3, 7, 2, 8};;
		boolean ans  = subSetSum(arr,11);
		int res = partition(arr);
		
		System.out.println(ans);
		System.out.println(res);

	}

}
