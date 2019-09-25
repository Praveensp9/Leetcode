package leetcode;

import java.util.Arrays;

public class LC322_CoinChange {
	
	private static int CoinChange(int amount,int[] coins) {
		
		//int max = Arrays.stream(coins).max().getAsInt();
		
		int[] dp = new int[amount+1];
		Arrays.fill(dp,amount+1);
		dp[0] = 0;
		
		for(int coin:coins) {
			for(int A=1;A<=amount;A++) {
				if(A>=coin)
					dp[A] = Math.min(dp[A], dp[A-coin]+1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
 	}
		
	public static void main(String[] args) {
		int[] coins = new int[] {1,2,5};
		int amount = 11;
		int ans = CoinChange(amount,coins);
		System.out.println(ans);
	}

}
