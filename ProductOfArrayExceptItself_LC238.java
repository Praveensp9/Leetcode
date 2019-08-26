package leetcode;


/**
 * @author Praveen Patil
 *
 */
public class ProductOfArrayExceptItself_LC238 {
	
	private static int[] solution(int[] arr) {
		int res[] = new int[arr.length];
		
		int cnt = 1;
		
		for(int i=0;i<arr.length;i++) {
			res[i] = cnt;
			cnt = cnt *arr[i];
		}
		cnt = 1;
		for(int i = arr.length-1;i>=0;i--) {
			res[i] = res[i] *cnt;
			cnt = cnt *arr[i];
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {5,2,6,3};
		int[] res = solution(arr);
		for(int i:res)
			System.out.print(i+" ");
	}

}
