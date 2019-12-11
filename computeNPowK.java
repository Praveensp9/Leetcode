package leetcode;

public class computeNPowK {
	
	private static double compute(int n,int k) {
		
		double r=1;
		int i = (k>0)?k:0-k;
		while(i-->0) {
			r=r*n;
		}
		
		return (k>0) ? r:1/r;
	}

	public static void main(String[] args) {
		int n=5;
		int k=-3;
		double res = compute(n,k);
		System.out.println(res);
	}

}
