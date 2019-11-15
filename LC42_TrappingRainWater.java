package leetcode;

public class LC42_TrappingRainWater {
	
	private static int trapRainWater(int[] arr) {
		
		
		int left=0;
		int right=0;
		int l=0;
		int r=arr.length-1;
		int water = 0;
		
		while(l<=r) {
			
			if(arr[l] < arr[r]) {
					if(arr[l]>left)
						left = arr[l];
					else
						water = water + left - arr[l];
				
					l++;
			}
			else {
					if(arr[r]>right)
						right = arr[r];
					else
						water = water + right - arr[r];
				
					r--;
				
			}
			
		}
		
		return water;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		int max = trapRainWater(arr);
		System.out.println(max);
 	}

}
