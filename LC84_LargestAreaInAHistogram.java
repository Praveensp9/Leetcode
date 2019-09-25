package leetcode;

import java.util.Stack;

public class LC84_LargestAreaInAHistogram {
	
	public LC84_LargestAreaInAHistogram(){
		
	}
	
	 public int largestRectangleArea(int[] heights) {
		 
		 	Stack<Integer> stk = new Stack<Integer>();
	        int i=0;
	        int n = heights.length;
	        
	        int max = 0;
	        while(i<n){
	            
	            if(stk.isEmpty() || heights[stk.peek()] <= heights[i])
	                stk.push(i++);
	            else{
	                
	                int top = stk.pop();
	                
	                int area = heights[top] * (stk.isEmpty() ? i : i-stk.peek()-1);
	                if(max<area)
	                    max = area;
	            }
	            
	        }
	        
	        while(!stk.isEmpty()){
	            
	            int top =stk.pop();
	            int area = heights[top] * (stk.isEmpty() ? i : i-stk.peek()-1);
	            if(max<area)
	                max = area;
	        }
	        
	        return max;
	 }

	public static void main(String[] args) {
		LC84_LargestAreaInAHistogram lc = new LC84_LargestAreaInAHistogram();
		int[] res = new int[] {1,2,3,4,5,3,3,2};
		int max = lc.largestRectangleArea(res);
		System.out.println(max);
		
	}

}
