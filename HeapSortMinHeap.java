package leetcode;
import java.util.*;

public class HeapSortMinHeap {

		
		private static void heap_sort(int[] arr){
			
			PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
			
			for(int i:arr)
				minheap.add(i);

			while(!minheap.isEmpty()) {
				System.out.println(minheap.remove());
			}

		}

		public static void main(String[] args) {

			int[] arr = new int[] {-9,-11,-1,9,3};
			heap_sort(arr);
		}

}