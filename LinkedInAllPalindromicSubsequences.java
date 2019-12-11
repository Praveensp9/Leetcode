package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedInAllPalindromicSubsequences {
	
	private static boolean isPalindrome(List<Character> tmp){
		
		if(tmp.size() == 0)
			return false;
		int l = 0, r = tmp.size() - 1;
		while(l < r) {
			if(tmp.get(l) != tmp.get(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	private static void palidromicSubsequence(String str,int cur,Set<String> res,List<Character> tmp){
		
		if(isPalindrome(tmp)) {
			StringBuilder sb = new StringBuilder();
			for(char c : tmp)
				sb.append(c);
			res.add(sb.toString());
		}
		
		for(int i=cur;i<str.length();i++) {
			char c = str.charAt(i);
			tmp.add(c);
			palidromicSubsequence(str, i+1, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
		
		
	}

	
	
	public static void main(String[] args) {
		String str = "aab";
		Set<String> res = new HashSet<>();
		
		palidromicSubsequence(str, 0, res, new ArrayList<>());
		System.out.println(res);

	}

}
