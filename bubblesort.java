package leetcode;

import java.util.Scanner;

public class bubblesort {

	private static int[] bubble_sort(int[] arr) {
		
		for(int i=0;i<arr.length -1;i++) {
			
			boolean s = false;
			for(int j=0;j<arr.length - i - 1 ;j++) {
				
				if(arr[j] > arr[j+1]) {
					int t = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = t;
					s= true;
				}
				
			
			}
			if(s == false)
				break;
			
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
		bubble_sort(arr);
		printarray(arr);

	}

}
