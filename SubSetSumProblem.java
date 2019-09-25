package leetcode;

public class SubSetSumProblem {
	
	// Time complexity -  O(input.size * total_sum)
	// Space complexity - O(input.size * total_sum)
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
	
	private static boolean partition(int[] arr) {
		
		int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] T = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i <= arr.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j - arr[i - 1]] || T[i - 1][j];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[arr.length][sum];

	}

	private static boolean subSetSumBackTrack(int[] set,int sum,int n) {
		
		if(sum == 0)
			return true;
		if( n == 0 && sum!=0)
			return false;
		if(set[n-1] > sum)
			return subSetSumBackTrack(set,sum,n-1);
		
		return subSetSumBackTrack(set,sum,n-1) || subSetSumBackTrack(set,sum-set[n-1],n-1);
	}

	public static void main(String[] args) {
		int arr[] = {3, 7, 2, 8};;
		boolean ans  = subSetSum(arr,11);
		boolean res = partition(arr);
		
		System.out.println(ans);
		System.out.println(res);

		boolean sum = subSetSumBackTrack(arr,11,4);
		System.out.println(sum);
	}

}
