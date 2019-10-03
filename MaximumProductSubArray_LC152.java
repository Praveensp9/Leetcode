package leetcode;

/**
 * @author Praveen Patil
 *
 */
public class MaximumProductSubArray_LC152 {
	
	private static int maximumproductsubarray(int[] arr) {

		int max =arr[0];
		int min =arr[0];
		int res =arr[0];
		
		for(int i=1;i<arr.length;i++) {
			int temp = max;
			
			max = Math.max(Math.max(max*arr[i], min*arr[i]), arr[i]);
			min = Math.min(Math.min(temp*arr[i], min*arr[i]), arr[i]);
			if(max>res)
				res = max;
		}
		
		return res;
	}

	public static void main(String[] args) {
		
		int[] arr = new int[] {2,-3,-12,-4,1};
		int res = maximumproductsubarray(arr);
		System.out.print(res);
	}

}
