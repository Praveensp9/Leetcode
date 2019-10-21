package leetcode;

import java.util.Stack;

public class AsteroidCollision {
	
	private static class Asteroid{
		int v;
		char sign;
		public Asteroid(int v,char s) {
			this.v=v;
			this.sign=s;
		}
	}

	private static void collision(int[] arr) {
		
		Stack<Asteroid> stk = new Stack<>();
		
		for(int i:arr) {
			
			char sign = '+';
			if(i<0)
				sign = '-';
			i = Math.abs(i);
			Asteroid ast = new Asteroid(i,sign);
			if(!stk.isEmpty()) {

				Asteroid temp = stk.peek();
				int val = temp.v;
				char s = temp.sign;

				if(s != sign && i>val) {
					
					stk.pop();
					stk.push(ast);
				}
				else if(s == sign){
					stk.push(ast);
				}
				else if(i==val) {
					stk.pop();
				}
		
			}
			else {

				stk.push(ast);
			}
		}
		while(!stk.isEmpty()) {
			System.out.print(stk.pop().v + " ");
		}
		
	}
	public static void main(String[] args) {
		
		int[] arr = new int[] {8, -8};
		
		collision(arr);
	}

}
