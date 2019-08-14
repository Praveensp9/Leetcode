package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class mergesort {
	
	private static void merge(int[] arr,int l,int m,int r) {
		
		int left =  m-l+1;
		int right = r-m;
		
		int[] l1 = new int[left];
		int[] l2 = new int[right];
		
		
		
		//Arrays.copyOfRange(arr, l,m);
		//Arrays.copyOfRange(arr, m,r);
		
		
		  for (int i=0; i<left; i++) 
			  l1[i] = arr[l + i]; 
		  for (int j=0; j<right; j++)
			  l2[j] = arr[m + 1 + j];
		 
		
	    int i=0;
		int j=0;
		
		int k=0;
		while(i < left && j < right) {
			
			if(l1[i] <=l2[j]) {
				arr[k] = l1[i];
				i++;
			}
			else {
				arr[k] = l2[j];
				j++;
			}
			k++;
			
		}
		
		//System.out.println(k);
		//System.out.println(i);
		while(i< left) {
			arr[k++] = l1[i++];
		}
		
		//System.out.println(j);
		while(j<right) {
			arr[k++] = l2[j++];
		}
		
		//return arr;
	}
	
	private static void merge_sort(int[] arr,int l,int r) {
		
		if(l<r) {
			
			int m = (l+r)/2;
			
			merge_sort(arr,l,m);
			merge_sort(arr,m+1,r);
			
			merge(arr,l,m,r);
			
		}
		//return arr;
	}

	private static void printarray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[] {12, 11, 13, 5, 6, 7}; 
		merge_sort(arr,0,arr.length-1);
		printarray(arr);
		
	}

}
