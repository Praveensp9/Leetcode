package leetcode;

public class LC10_RegularExpressionMatching {
	
	private static boolean isMatch(String s, String p) {
		
		int m = s.length()+1;
		int n = p.length()+1;
		boolean[][] dp = new boolean[m][n];
		
		dp[0][0] = true;
		
		// For the first row : Eg pattern like , a*b*, a*, c*v*a* and empty string
		for (int i = 1; i < n; i++) {
            if (p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
			
		
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				
				if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
					dp[i][j]  = dp[i-1][j-1];
				else if(p.charAt(j-1) == '*') {
					dp[i][j] = dp[i][j-2];
					if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2)=='.')
						dp[i][j] = dp[i][j] | dp[i-1][j];
				}
				else {
					dp[i][j] = false;
				}
			}
		}
		
		return dp[m-1][n-1];
    }

	public static void main(String[] args) {
		boolean res = isMatch("xaabc","xa*b.c");
		System.out.println(res);
	}

}
