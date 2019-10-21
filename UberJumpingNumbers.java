package leetcode;

import java.util.ArrayList;
import java.util.List;

public class UberJumpingNumbers {
	
	private static List<Integer> res = new ArrayList<>();
	
	private static boolean isJumping(int n) {
			String[] digits = new Integer(n).toString().split("");
			for(int i=0;i<digits.length-1;i++) {
				int n1 = Integer.valueOf(digits[i]);
				int n2= Integer.valueOf(digits[i+1]);
				if (Math.abs(n1-n2) != 1) 
					return false;
			}
		return true;
	}
	
	private static List<Integer> jumpingNumbers(int n) {
		for(int i=0;i<=n;i++) {
			if(isJumping(i))
				res.add(i);
		}
		return res;
	}

	public static void main(String[] args) {
		int N = 105;
		List<Integer> lst = jumpingNumbers(105);
		for(int i:lst)
			System.out.print(i+" ");
	}

}
