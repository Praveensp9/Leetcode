package leetcode;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
	
	private static class ArrayContainer implements Comparable<ArrayContainer>{
		int[] arr;
		int index;
		
		public ArrayContainer(int[] arr,int index) {
			this.arr = arr;
			this.index = index;
		}

		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr[this.index] - o.arr[o.index];
		}
		
	}
	private static int[] mergeKSortedArrays(int[][] arr) {
		
		int k = arr.length;
		
		PriorityQueue<ArrayContainer> q = new PriorityQueue<ArrayContainer>();
		int total=0;
		
		for(int i=0;i<k;i++) {
			q.add(new ArrayContainer(arr[i],0));
			total = total + arr[i].length;
		}
		
		int m = 0;
		int res[] = new int[total];
		
		while(!q.isEmpty()) {
			ArrayContainer ac= q.poll();
			res[m++] = ac.arr[ac.index];
			if(ac.index < ac.arr.length-1) {
				q.add(new ArrayContainer(ac.arr,ac.index+1));
			}
		}
		
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = new int[][] { {2, 6, 12, 34}, 
					                {1, 9, 20, 1000}, 
					                {23, 34, 90, 2000}
								  };
								  
		int[] res = mergeKSortedArrays(arr); 
		for(int i:res)
			System.out.print(i+" ");

	}

}
