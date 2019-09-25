package leetcode;

import java.util.Arrays;

public class DailyCodingProblem_102 {
	
	private static int[] sum(int[] arr,int k) {
		int i=0;
		int j=0;
		
		int sum = 0;
		
		while(j<=arr.length && sum !=k) {
			if(sum<k)
				sum+=arr[j++];
			else
				sum-=arr[i++];
		}
		
		int[] res = new int[j-i];
		
		res = Arrays.copyOfRange(arr, i, j);
		return res;
	}

	public static void main(String[] args) {
		int[] res = sum(new int[]{1,2,3,4,5},9);
		for(int i:res)
			System.out.print(i+" ");
	}

}
