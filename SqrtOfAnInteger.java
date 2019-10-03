package leetcode;

public class SqrtOfAnInteger {
	
	// Linear Search : T.C : O(sqrt(n))
	
	private static int sqrt(int x) {
		
		int i=1;
		int res=1;
		
		while(res<=x) {
			i++;
			res = i*i;
		}
		return i-1;
	}

	// Binary Search : T.C : O(log n)
	private static int sqrtMethod(int x) {
		
		if(x<=0)
			return 0;
		int l=1;
		int r=x;
		int res = 1;
		
		while(l<r) {
		
			int mid = l + (r-l)/2;
			
			if(mid > x/mid)
				r = mid;
			else {
				res = mid;
				l = mid+1;
			}
		}
		return res;
		
	}
	public static void main(String[] args) {
		int x = 25;
		int res = sqrtMethod(x);
		System.out.println(res);
		int res1 = sqrt(x);
		System.out.println(res1);
	}

}
