package leetcode;

public class LC1143_LargestCommonSubsequence {

	
	private static int largestCommonSubsequence(String s1,String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = 1+dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
//		
//		int index = dp[n][m];
//		int temp = index;
//		char[] lcs = new char[index+1];
//		lcs[index] =  ' ';
		
		StringBuilder sb = new StringBuilder();
		int i = n;
		int j = m;
		
		while(i>0 && j>0) {
			
			if(s1.charAt(i-1) == s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			}
			else if(dp[i-1][j] > dp[i][j-1])
				i--;
			else
				j--;
		}
		
		System.out.println(sb.reverse().toString());
		return dp[n][m];
	}
	
	public static void main(String[] args) {
			
		int res = largestCommonSubsequence("AGGTAB","GXTXAYB");
		System.out.println(res);
	}

}
