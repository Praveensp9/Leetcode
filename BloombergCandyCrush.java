package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BloombergCandyCrush {
	
	private static String candyCrush(String str) {
	
		Stack<Character> s = new Stack<Character>();
		Map<Character,Integer> map = new HashMap<>();
		
		for(char c:str.toCharArray()) {
			
			if(s.isEmpty()) {
				
				s.push(c);
				map.put(c, map.getOrDefault(c, 0)+1);
			}
			else if(s.peek() == c) {
				map.put(c, map.getOrDefault(c, 0)+1);
			}
			else if(s.peek() != c) {
				System.out.println(s.peek()+" : "+map.get(s.peek()));
				if(map.get(s.peek())>=3) {
					map.remove(s.peek());
					s.pop();
				}
				s.push(c);
				map.put(c, map.getOrDefault(c, 0)+1);
			}
			
//		  while(!s.isEmpty() && map.get(s.peek())>=3) {
//				map.remove(s.peek());
//				s.pop();
//			}
//		 
		}
		
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty()) {
			
			sb.append(s.pop());
		}
		
		
		
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		
		String str = candyCrush("aabbccddeeedcba");
		System.out.println(str);
	}

}
