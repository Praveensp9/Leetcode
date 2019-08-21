package leetcode;

import java.util.*;

public class BucketSort {
	
	
//	private static int hash(int i) { 
//		return (int) ((double) i / code[0] + (code[1] - 1)); 
//	}
	
	private static void bucketsort(int[] arr) {
		int n=arr.length;
		int M = 20; // (max - min)
		int minVal = 2;
		
		// 1) Create n empty buckets  and initialize to Arraylist O(n)
		List<Integer>[] lst = new ArrayList[n];
		for(int i=0;i<n;i++) {
			lst[i] = new ArrayList<>();
		}
	
		
		// 2) Put array elements in different buckets 
		for(int i=0;i<arr.length;i++) {
			int hash = (arr[i] - minVal) / M;
			System.out.println(hash);
			lst[hash].add(arr[i]);
		}
		
		
		
		// 3) Sort individual buckets 
		for(List buckets : lst) {
			Collections.sort(buckets);
		}
		
		// 4) Concatenate all buckets into arr[] 
		int index = 0;
		for(int b=0;b<lst.length;b++) {
			for(int i : lst[b])
				arr[index++] = i;
		}
		
	}
	
	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[] {6,25,12,22,11,1,1,3,35,-1};
		bucketsort(arr);
		printarray(arr);
	}

}
