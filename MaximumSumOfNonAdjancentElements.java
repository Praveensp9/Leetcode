package leetcode;

public class MaximumSumOfNonAdjancentElements {
	
	
	private static int maxSum(int[] arr) {
		
		int excl = 0;
		int incl = arr[0];
		
		for(int i=1;i<arr.length;i++) {
			int temp = incl;
			incl = Math.max(excl+arr[i], incl);
			excl = temp;
		}
		
		return incl;
	}

	public static void main(String[] args) {
		
		int[] arr = new int[] {1,0,3,9,2};
		int ans = maxSum(arr);
		System.out.println(ans);
		
	}

}
