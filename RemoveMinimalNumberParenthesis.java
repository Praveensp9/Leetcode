package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.LinkedList;

public class RemoveMinimalNumberParenthesis {
	
		  
	    private static boolean checkValid(String s) 
	    {
	        Stack<Character> stack = new Stack<>();
	        for(char ch: s.toCharArray()) {
	            if(ch == '(') {
	                stack.push('(');
	            } else if(ch == ')') {
	                if(stack.size() == 0) return false;
	                stack.pop();
	            }
	        }
	        return stack.size() == 0;
	    }
	    
	    private  static List<String> removeInvalidParentheses(String s) {
	        
	        List<String> ans = new ArrayList<>();
	        if(s == null || s.length() == 0) {
	            ans.add("");
	            return ans;
	        }
	        Queue<String> queue = new LinkedList<>();
	        queue.add(s);
	        
	        boolean flag = false;
	        
	        Set<String> set = new HashSet<>();
	        Set<String> visited = new HashSet<>();
	        
	        while(!queue.isEmpty()) {
	            int level = queue.size();
	            for(int i = 0; i <= level - 1; i++) {
	                String top = queue.poll();
	                if(visited.contains(top)) continue;
	                if(checkValid(top)) {
	                    flag = true;
	                    set.add(top);
	                }
	                if(!flag) {
	                    visited.add(top);
	                    for(int j = 0; j <= top.length() - 1; j++) {
	                       char curr = top.charAt(j);
	                       if(curr != '(' && curr != ')') continue;
	                       String add = top.substring(0, j) + top.substring(j+1, top.length());
	                       queue.add(add);
	                   } 
	                }
	            }
	            if(flag) break;
	        }
	        ans.addAll(set);
	        return ans;
	    }

	public static void main(String[] args) {
		List<String> res = removeInvalidParentheses("(a)())()");
		for(String s:res)
			System.out.println(s);
	}

}
