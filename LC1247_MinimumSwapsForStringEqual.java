package leetcode;

public class LC1247_MinimumSwapsForStringEqual {

	private static int swaps(String s1,String s2) {

		int x=0;
        int y=0;
        
        int n=s1.length();
        
        for(int i=0;i<n;i++){
            
            if(s1.charAt(i) != s2.charAt(i)){
                
                if(s1.charAt(i) == 'x')
                    x++;
                else
                    y++;
            }
        }
        
        int cnt = x+y;
        
        if(cnt %2 == 1)
            return -1;
        
        return cnt/2 + x%2;
		

	}
	
	public static void main(String[] args) {
		int res = swaps("yxyx","yxyx");
		System.out.println(res);
	}

}
