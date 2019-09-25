package leetcode;

public class LC518_CoinChangeProblem_2 {
	
	private static int CoinChange2(int amount, int[] coins) {
		
		int[] dp = new int[amount+1];
		
		dp[0]=1;
		
		for(int coin:coins) {
			
			
			for(int i=1;i<=amount;i++) {
				if(i>=coin)
					dp[i] += dp[i-coin]; 
				
			}
		}
		return dp[amount];
		
	}

	public static void main(String[] args) {
			int[] coins = new int[] {1,2,5};
			int amount = 5;
			int ans = CoinChange2(amount,coins);
			System.out.println(ans);
	}

}
