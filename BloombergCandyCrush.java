package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BloombergCandyCrush {
		
	private static class C{
        private int freq;
        private char c;
        
        public C(char c, int f){
            this.freq = f;
            this.c = c;
        }
    }
    
    private static String candyCrush1(String s) {

        Stack<C> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        for(char c:s.toCharArray()) {
        	map.put(c,map.getOrDefault(c, 0)+1);
        }

        for(char c: s.toCharArray()){
            if(!st.isEmpty() && st.peek().c == c) 
                st.push(new C(c,st.peek().freq+1));
            else 
                st.push(new C(c,1));
            
            if( st.peek().freq >= 3 && map.get(c) == st.peek().freq){
            	
                int tmp = st.peek().freq;
                char ch = st.peek().c;
                while(tmp-- > 0) {
                	st.pop(); 
                	map.put(ch, map.get(ch)-1);
                }
            }             
        }

        while(!st.isEmpty()) {
        	char c = st.pop().c;
        	sb.append(c);
        }
        
        return sb.reverse().toString();
    }
    
    private static String candyCrush2(String s) {

        Stack<C> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            if(!st.isEmpty() && st.peek().c == c) 
                st.push(new C(c,st.peek().freq+1));
            else 
                st.push(new C(c,1));
            
            if( st.peek().freq >= 3){
            	
                int tmp = st.peek().freq;
                while(tmp-- > 0) {
                	st.pop(); 
                }
            }             
        }

        while(!st.isEmpty()) {
        	char c = st.pop().c;

        	sb.append(c);
        }

        return sb.reverse().toString();
    }
    
    
    private static String solve(String input) {
    	 //String input = (new Scanner(System.in)).nextLine();
    		
    		int i=0;
    	    while(i<input.length()) {
    	        int j = i;
    	        while (j < input.length() && input.charAt(j) == input.charAt(i))
    	            j++;

    	        if (j - i > 2) {
    	            input = input.substring(0, i) + input.substring(j);
    	            
    	            i = 0;
    	        }
    	        else {
    	        	i++;
    	        }
    	    }

    	    return input;
    }

	public static void main(String[] args) {
		
		String str = candyCrush1("aaabbccddeeedcba");
		if(str.length() == 0)
			System.out.println("\"\"");
		else
			System.out.println(str);
		
		String str1 = candyCrush2("aaabbccddeeedcba");
		if(str1.length() == 0)
			System.out.println("\"\"");
		else
			System.out.println(str1);
		
		String str2 = solve("aaabbccddeeedcba");
		if(str2.length() == 0)
			System.out.println("\"\"");
		else
			System.out.println(str2);
	}

}
