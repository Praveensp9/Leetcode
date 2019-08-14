package leetcode;

import java.util.*;

public class heapsort {
	
	private static int[] heapSortUsingMaxHeap(int[] arr) {
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(
		
			new Comparator<Integer>() {
				public int compare(Integer a,Integer b) {
					return b-a;
				}
			}
		);
		
		for(int i:arr)
			maxheap.add(i);
		
		int k=0;
		
		for(int i=0;i<arr.length;i++) {
			if(!maxheap.isEmpty())
				arr[k++] = maxheap.remove();
		}

		return arr;
	}

	private static int[] heap_sort(int[] arr) {
		
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
		
		for(int i:arr)
			minheap.add(i);
		
		int k=0;
		
		for(int i=0;i<arr.length;i++) {
			if(!minheap.isEmpty())
				arr[k++] = minheap.remove();
		}

		return arr;
	}

	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[] {64,25,12,22,11};
		heap_sort(arr);
		printarray(arr);
		heapSortUsingMaxHeap(arr);
		printarray(arr);
	}

}
