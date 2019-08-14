package leetcode;

import java.util.*;
import java.io.*;

public class selectionsort {
	
	private static int[] selection_sort(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			
			int left = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[j] < arr[left]) {
					left = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[left];
			arr[left] =temp;
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
		selection_sort(arr);
		printarray(arr);
		

	}

}
