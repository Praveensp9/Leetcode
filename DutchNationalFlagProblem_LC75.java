package leetcode;

public class DutchNationalFlagProblem_LC75 {
	
	private static int[] arr = {2,0,2,1,1,0,2,0,0,1,1,1,2,0,1,0,2,1,0};
	private static void sort(int[] arr) {
		
		
		int i=0;
		int j=0;
		int n = arr.length - 1;
		
		while(j<=n) {
			if(arr[j]<1) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
				j++;
			}
			else if(arr[j]>1) {
				int t = arr[j];
				arr[j] = arr[n];
				arr[n] = t;
				n--;
			}
			else
				j++;
		}
	}

	public static void main(String[] args) {
			sort(arr);
			for(int i:arr)
				System.out.print(i + " ");
	}

}
