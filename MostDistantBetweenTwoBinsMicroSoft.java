package leetcode;

public class MostDistantBetweenTwoBinsMicroSoft {
	
	private static int[] distant(int[] arr) {
		int n = arr.length;
		int mid = n/2;
		int l=0,r=0;
		if(n%2 == 0){
			l=r= mid-1;
		}
		else{
			l=r=mid;
		}
		int left = arr[mid];
		int right = arr[mid];
		
		while(l>=0 && r <n) {
			
			if(arr[l] > left)
				left = arr[l];
			if(arr[r] > right)
				right = arr[r];
			if(arr[l] <= arr[r])
				l=l-1;
			else
				r=r+1;
		}
		return new int[] {left,right};
			
	}

	public static void main(String[] args) {
		int[] res = distant(new int[] {9,7,31,2,3,1,6,3,1,9});
		System.out.println(res[0]+" , "+res[1]);
	}

}
