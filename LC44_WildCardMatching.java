package leetcode;

public class LC44_WildCardMatching {
	
    private static boolean wildCardMatch(String s, String p) {
        
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        
        for(int i=1;i<=n;i++){
            dp[0][i] = (p.charAt(i-1) == '*') && dp[0][i-1];
        }
        
        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                
            if(p.charAt(j-1) !='*')
                    dp[i][j] = (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) && dp[i-1][j-1];
                
                else
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
        
        return dp[m][n];
    }

	public static void main(String[] args) {
		boolean res = wildCardMatch("xaabac","xa*b?c");
		System.out.println(res);
	}

}
