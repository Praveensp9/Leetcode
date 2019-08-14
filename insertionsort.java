package leetcode;

import java.util.Scanner;

public class insertionsort {
	
	

	private static int[] insertion_sort(int[] arr) {
		
		for(int i=1;i<arr.length;i++) {
			
			int base = arr[i];
			
			int j = i-1;
			
			while(j>=0 && arr[j] > base) {
				arr[j+1] = arr[j];
				j--;
			}
			
			arr[j+1] = base;
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
		//Scanner sc = new Scanner(new StringReader(input));
		
		int[] arr = new int[] {64,25,12,22,11};
		insertion_sort(arr);
		printarray(arr);
		
	}

}
