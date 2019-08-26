package leetcode;

import java.util.Stack;

public class RemoveAllAdjancentDuplicatesInString_LC1047 {
	
	
	private static String leetcode_1047(String str) {
		
		Stack<Character> stk = new Stack<>();
		int n = str.length();
		int i = 0;
		
		while(i<n) {
			
			if(!stk.isEmpty() && str.charAt(i) == stk.peek()) {
				stk.pop();
			}
			else {
				stk.push(str.charAt(i));
			}
			
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while(!stk.isEmpty())
			sb.append(stk.pop());
		return sb.reverse().toString();
		
	}

	public static void main(String[] args) {
		String str = "ddbacca";
		String res = leetcode_1047(str);
		
		System.out.println(res);
	}

}
