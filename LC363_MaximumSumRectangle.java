package leetcode;

public class LC363_MaximumSumRectangle {
	
	
	private static class KadaneResult{
		int maxSum = 0;
		int top = 0;
		int down = 0;
		public KadaneResult(int maxSum,int top,int down) {
			this.maxSum = maxSum;
			this.top = top;
			this.down = down;
		}
	}
	
	private  static class Result{
		int maxSum = 0;
		int left = 0;
		int right = 0;
		int top = 0;
		int down = 0;
	}
	
	private static KadaneResult maximumSumSubArray(int[] arr) {
		int sum = 0;
		int max = 0;
		int cs = 0;
		int s = 0;
		int e =0;
		
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
			if(sum<0) {
				sum = 0;
				cs = i+1;
			}
			
			if(max < sum) {
				max = sum;
				s = cs;
				e = i;
			}
		}
		
		return new KadaneResult(max,s,e);
	}
	
	private static Result maximumSumRectangle(int[][] rectangle) {
		
		
		int row = rectangle.length;
		int col = rectangle[0].length;
		Result res= new Result();
		for(int left = 0;left<col;left++) {
			
			int[] temp = new int[row];
			for(int right = left;right<col;right++) {
				for(int i=0;i<row;i++)
					temp[i]+=rectangle[i][right];
			
			
			KadaneResult kr = maximumSumSubArray(temp);
			if(kr.maxSum > res.maxSum) {
				res.maxSum = kr.maxSum;
				res.left = left;
				res.right = right;
				res.top = kr.top;
				res.down = kr.down;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		 int input[][] = {{ 2,  1, -3, -4,  5},
		                 { 0,  6,  3,  4,  1},
		                 { 2, -2, -1,  4, -5},
		                 {-3,  3,  1,  0,  3}};
		 Result res = maximumSumRectangle(input);
		 System.out.println(res.maxSum);

	}
}
