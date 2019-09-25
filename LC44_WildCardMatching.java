package leetcode;

public class LC44_WildCardMatching {
	
	private static boolean wildCardMatch(String s, String p) {
		
		int m= s.length();
		int n= p.length();
		boolean[][] dp = new boolean[m+1][n+1];
		
		return dp[m][n];
	}
		

	public static void main(String[] args) {
		boolean res = wildCardMatch("xaabc","xa*b?c");
		System.out.println(res);
	}

}
