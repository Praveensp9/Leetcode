package leetcode;

public class UberKeyBoardOperation {
	
	public int maxA(int N) {    
        
        int[] dp = new int[N+1];
        
        for(int i=0;i<N+1;i++){
            
            if(i<4){
                dp[i] = i;
            }
            else{
                int max = i;
                
                for(int k=i-3;k>=1 && k>=i-6;k--)
                    max = Math.max(max,dp[k]*(i-k-1));
                dp[i] = max;
            }
            
        }
        return dp[N];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
