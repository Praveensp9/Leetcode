package leetcode;

public class LongestPalindromicSubString {
	
	
	// // T.C : O(n^2) - Dynamic Programming Force and S.C : O(n^2)
	private static String longestPalindromicSubstringDP(String s) {
		
		int n = s.length();
		boolean[][] dp = new boolean[n][n]; 
		
		for(int i=0;i<n;i++)
			dp[i][i] = true;
		
		int start = 0;
		int max = 0;
		for(int i=0;i<n-1;i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				dp[i][i+1] = true;
				start = i;
				max = 2;
			}
		}
		
		
		for(int len=3;len<=n;len++) {
			
			for(int i=0;i<n-len+1;i++) {
				int j=i+len-1;
				 
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
					dp[i][j] = true;
					
					if(max<len) {
						max=len;
						start=i;
					}
				}
			}
		}
		
		String palindrome = s.substring(start,start+max);
		return palindrome;
	}
	
	// T.C : O(n^3) - Brute Force and S.C : O(1)
	private static boolean palindrome(String sub , int l,int r){
	        
	        while(l<=r){
	            
	            if(sub.charAt(l) == sub.charAt(r)){
	                l++;
	                r--;
	            }
	            else
	                return false;
	        }
	        return true;
	        
	  }
	
	
	private static String longestPalindromicSubstring(String s) {
		  if (s == null || s.length() < 1)
	            return "";
	        int n = s.length();
	         int max = 0;
	         String palidrome="";
	        for(int i=0;i<n;i++){
	            
	            for(int j=i+1;j<=n;j++){
	          
	                String sub = s.substring(i,j);
	                boolean flag = palindrome(sub,0,sub.length()-1);
	                if(flag)
	                {
	                    if(max<sub.length()){
	                        max = sub.length(); 
	                        palidrome = sub;
	                    }
	                }
	                
	            }
	        }
	         
	         return palidrome;
	}

	public static void main(String[] args) {
		String res = longestPalindromicSubstring("agbdba");
		System.out.println(res);
		
		String res1 = longestPalindromicSubstringDP("agbdba");
		System.out.println(res1);

	}

}
