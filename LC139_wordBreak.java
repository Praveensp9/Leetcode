package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC139_wordBreak {
	
	private static boolean wordBreak(List<String> words,String word) {
		
		if(word == null || words == null)
	          return false;
		
		int n = word.length();
		boolean[] dp = new boolean[n+1];
		
		dp[0] = true;
		
		
		for(int i=1;i<=n;i++) {
			
			for(int j=0;j<i;j++) {
				if(dp[j] && words.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[n];
	}
	
	private static void helper(List<String> words,String word,int start,String sol,List<String> result) {
		
		if(start == word.length()) {
			result.add(sol);
			return;
		}
		
		for(int i=start;i<word.length();i++) {
			String sub = word.substring(start, i + 1);
			
			if (words.contains(sub))
		        helper(words, word, i + 1, sol + (sol.length() == 0 ? "" : " ") + sub, result);
		}
	}
	
	//LC 140
	private static List<String> wordBreakII(List<String> words,String word) {
		
		 List<String> res = new ArrayList<String>();
		  if (!wordBreak(words, word))
		      return res;
		 
		  helper(words, word, 0, "", res);
		  return res;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> words = new ArrayList<String>();
		words.add("apple");
		words.add("pen");
		words.add("applepen");
		words.add("pine");
		words.add("pineapple");
		String word = "pineapplepenapple";
		boolean flag = wordBreak(words,word);
		System.out.println(flag);
		
		List<String>  result = wordBreakII(words,word);
		
		for(String s:result)
			System.out.println(s);
	}

}
