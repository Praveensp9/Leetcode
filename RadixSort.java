package leetcode;

import java.util.Arrays;
import java.util.Scanner;
import leetcode.CountingSort;

public class RadixSort {
	
	
	private static void counting_sort(int[] arr,int e) {
		int n = arr.length;
		
		int[] tmp = new int[10];
		for(int i=0;i<n;i++)
			tmp[(arr[i]/e)%10]++;
		for(int i =1;i<10;i++)
			tmp[i]=tmp[i] + tmp[i-1];
		
		int[] output= new int[n];
 		for(int i=n-1;i>=0;i--) {

			output[tmp[ (arr[i]/e)%10]-1] = arr[i];
			tmp[(arr[i]/e)%10]--;
		}
 		for(int i=0;i<n;i++)
 			arr[i]=output[i];
	}
	
	private static void radixSort(int[] arr) {
		//CountingSort sort = new CountingSort();
		int m = Arrays.stream(arr).max().getAsInt(); 
	
		for (int i = 1; m/i > 0; i *= 10) 
			counting_sort(arr,i);
	}
	
	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[] {64,25,12,22,11};
		radixSort(arr);
		printarray(arr);

	}

}
