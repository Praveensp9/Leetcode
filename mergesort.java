package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class mergesort {
	
	private static void merge(int[] nums,int start, int mi, int end) {
		
		int lp = start;
        int rp = mi + 1;
        int[] buffer = new int[end-start+1];
        int t = 0;
        
        while (lp <= mi && rp <= end){
            if (nums[lp] < nums[rp]){
                buffer[t++] = nums[lp++];
            }else{
                buffer[t++] = nums[rp++];
            }
        }
        
        while (lp <= mi) 
            buffer[t++] = nums[lp++];
        while (rp <= end) 
            buffer[t++] = nums[rp++];
        for (int i = start; i <= end; i++){
            nums[i] = buffer[i-start];
        }
		
	}
	
	private static void merge_sort(int[] arr,int l,int r) {
		
		if(l<r) {
			
			int m = l+ (r-l)/2;
			
			merge_sort(arr,l,m);
			merge_sort(arr,m+1,r);
			
			merge(arr,l,m,r);
			
		}
	
	}

	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[] {18,33,45,1,12,-45,4,2,3}; 
		merge_sort(arr,0,arr.length-1);
		printarray(arr);
		
	}

}
