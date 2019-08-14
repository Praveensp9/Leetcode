package leetcode;

import java.util.*;

public class sortAnAlmostSortedArray {
	
	private static int[] sort(int[] arr,int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<=k;i++) {
			pq.add(arr[i]);
		}
		int j =0;
		
		for(int i= k+1;i<arr.length;i++) {
			arr[j++] = pq.peek();
			pq.remove();
			pq.add(arr[i]);
		}
		
		while(!pq.isEmpty())
		{
			arr[j++] = pq.peek();
			pq.remove();
		}
		
		return arr;
	}
	
	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[]{6, 5, 3, 2, 8, 10, 9};
		arr = sort(arr,3);
		printarray(arr);
	}

}
