package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC525_Quora_ContinguosArrayWith1and0 {

	private static int continuos(int[] arr) {
		
		Map<Integer,Integer> map = new HashMap<>();
		int cnt = 0;
		int max = 0;
		map.put(0,-1);
		for(int i=0;i<arr.length;i++) {
			
			cnt+= (arr[i] == 1) ? 1 : -1;
			
			if(map.containsKey(cnt)) {
				max = Math.max(max, i-map.get(cnt));
			}
			else
				map.put(cnt,i);
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,0,1,1,0,0,0,0,0,0,0,1};
		int max = continuos(arr);
		System.out.println(max);
	}

}
