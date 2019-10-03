package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
	
	// Finding max and min element in an array using Java Stream
	// int max = Arrays.stream(arr).max().getAsInt(); 
    // int min = Arrays.stream(arr).min().getAsInt(); 
	
	private static int[] coutingsorthandlingnegativeelements(int[] arr) {
		
		int max = Arrays.stream(arr).max().getAsInt(); 
        int min = Arrays.stream(arr).min().getAsInt(); 
        int range = max - min + 1; 
        int[] tmp = new int[range]; 
        int output[] = new int[arr.length]; 
        
        for (int i:arr)  
            tmp[i - min]++; 
   
        for (int i = 1; i < tmp.length; i++)
            tmp[i] += tmp[i - 1];
  
        for (int i = arr.length - 1; i >= 0; i--)  { 
            output[tmp[arr[i] - min] - 1] = arr[i]; 
            tmp[arr[i] - min]--; 
        } 
        return output;
	}
	
	public static int[] coutingsort(int[] arr) {
		
		// First, find the maximum value in arr
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			max = Math.max(max, arr[i]);
		}
		
		// Initialize the elements of tmp[] with 0
		int[] tmp = new int[max+1];
		
		// Result Sorted Array
		int[] output = new int[arr.length];
		
		// Store the frequencies of each distinct element of arr,
		// by mapping its value as the index of arr array
		for(int i:arr)
			tmp[i]++;
		
		
		// Change tmp[i] so that tmp[i] now contains actual 
        // position of this character in output array 
		for(int i=1;i<=max;i++)
			tmp[i]= tmp[i]+tmp[i-1];
		
		
		// Build the output character array 
        // To make it stable we are operating in reverse order.
		for(int j=arr.length-1;j>=0;j--){
			output[tmp[arr[j]]-1] = arr[j];
			tmp[arr[j]]--;
		}
		return output;
	}
	
	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		
	
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[] {1,9,2,3,5,5,12,10};
		int[] res= coutingsort(arr1);
		printarray(res);
		int[] arr = new int[] {-5, -10, 0, -3, 8, 5, -1, 10};
		int[] res1 = coutingsorthandlingnegativeelements(arr);
		printarray(res1);
	}

}
