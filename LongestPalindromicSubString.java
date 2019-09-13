package leetcode;

public class LongestPalindromicSubString {
	
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
		String res = longestPalindromicSubstring("babad");
		System.out.println(res);

	}

}
