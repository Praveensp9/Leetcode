package leetcode;

import java.util.Scanner;

public class quicksort {
	
	private static int partition(int[] arr, int start, int end){
        
		//int m = start+(end-start)/2;
        int pivot = arr[end];
        int i = start-1;
        
        
        for(int j=start;j<end;j++){
            
            if(arr[j] <=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }
		

	
	private static int[] quick_sort(int[] arr,int low,int high) {
		 
		if(low<high){
	            int res = partition(arr,low,high);
	            quick_sort(arr,low,res-1);
	            quick_sort(arr,res+1,high);
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
		quick_sort(arr,0,arr.length-1);
		printarray(arr);
		
	}
}
