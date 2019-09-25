package leetcode;

public class MaximumDifferenceLargerAppearsAfterSmaller {

	// T.C : O(N) S.C : O(1)
	private static int maximumDifference(int[] arr) {
		
		int max = arr[1] - arr[0];
		int min = arr[0];
		int max_index = 0;
		int min_index = 0;
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i] - min > max) {
				max = arr[i] - min;
				max_index += i;
			}
			if(arr[i] < min ) {
				min = arr[i];
			}
			
		}
		
		System.out.println(min_index + " : " + max_index);
		return max;
	}
		
	public static void main(String[] args) {

		int ans = maximumDifference(new int[] {18, 19, 10, 6, 4, 0, 2});
		System.out.println(ans);
	}

}
