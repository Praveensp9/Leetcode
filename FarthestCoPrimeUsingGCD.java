package leetcode;

public class FarthestCoPrimeUsingGCD {

	
	private static int farthestCoprime(int a) {
		
		for(int i=2;i<250;i++) {
			int g = gcd(a,i);
			if(g == 1)
				return i;
		}
		
		return -1;
	}
	
	// Recursive Solution by substraction
	private static int gcd(int a, int b) {
		
		if(a == 0)
			return b;
		if(b == 0)
			return a;
		if(a == b)
			return a;
		
		if(a>b)
			return gcd(a-b,b);
		return gcd(a,b-a);
		
	}
	
	// Recursive Solution by eucleadean algorithm
		private static int gcd1(int a, int b) {
		
			if(b == 0)
				return a;
			return gcd(b,a%b);
			
		}
	
//	private static int primeFactors(int a, int b) {
//		
//	}
	
	public static void main(String[] args) {
		int b = farthestCoprime(2);
		System.out.println(b);
		
		int ans = gcd1(20,24);
		System.out.println(ans);
		
//		int ans = primeFactors(20,24);
//		System.out.println(ans);
//		
		

	}

}
