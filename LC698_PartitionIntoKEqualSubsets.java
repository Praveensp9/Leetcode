package leetcode;

public class LC698_PartitionIntoKEqualSubsets {
	
	 private static boolean canPartitionKSubsets(int[] arr, int k) {
	
		    int sum = 0;
	        for (int i = 0; i < arr.length; i++) {
	            sum += arr[i];
	        }

	        if (sum % k != 0) {
	            return false;
	        }
	        sum = sum / k;
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

	public static void main(String[] args) {
		int arr[] = {4, 3, 2, 3, 5, 2, 1};
		int k=4;
		boolean res = canPartitionKSubsets(arr,4);
		System.out.println(res);
	}

}
