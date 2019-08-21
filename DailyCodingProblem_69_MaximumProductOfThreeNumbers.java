package leetcode;

public class DailyCodingProblem_69_MaximumProductOfThreeNumbers{
	
	private static int MaximumProductOfThreeNumbers(int[] arr) {
		int max1 = -1001;
		int max2 = -1001;
		int max3 = -1001;
		int min1 = 1001;
		int min2 = 1001;
		
		for(int i : arr) {
			
			if(max1<i) {
				max3=max2;
				max2=max1;
				max1=i;
			}
			else if(max2<i) {
				max3=max2;
				max2=i;
			}
			else if(max3<i) {
				max3=i;
			}
			
			if(i<min1) {
				min2=min1;
				min1=i;
			}
			else if(i<min2) {
				min2=i;
			}
		}
		
		int max = Math.max(max1*max2*max3,min1*min2*max1);
		return max;
		
	}
	

	public static void main(String[] args) {
		int[] arr = new int[] {-10,-10,5,2};
		int ans = MaximumProductOfThreeNumbers(arr);
		System.out.println(ans);

	}

}
