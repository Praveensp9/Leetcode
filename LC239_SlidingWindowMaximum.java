package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239_SlidingWindowMaximum {
	
	private static int[] slide(int[] arr,int k) {
		
		if(arr == null || k<=0)
			return new int[] {};
		
		int n = arr.length;
		int[] res = new int[n-k+1];
		Deque<Integer> q = new ArrayDeque<>();
		int j=0;
		
		for(int i=0;i<n;i++) {
			
			
			if(!q.isEmpty() && q.peek() < i-k+1 ) {
				q.poll();
			}
			
			while(!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
				q.pollLast();
			}
			
			q.offer(i);
			if(i>=k-1)
				res[j++] = arr[q.peek()];
			
		}
		return res;
		
		
	}

	public static void main(String[] args) {
		
		int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
		int[] res = slide(arr,3);
		for(int i:res)
			System.out.print(i+" ");

	}

}
