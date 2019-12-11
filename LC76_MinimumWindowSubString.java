package leetcode;

public class LC76_MinimumWindowSubString {
	
	private static String miniMumWindow(String str,String sub) {
		
		int[] map = new int[128];
		for(char c:sub.toCharArray())
			map[c] = map[c] + 1;
		
		int len = Integer.MAX_VALUE;
		int begin = 0;
		int cnt = sub.length();
		
		for(int left =0,right=0;right<str.length();right++) {
			char c = str.charAt(right);
			map[c]--;
			if(map[c] >= 0)
				cnt--;
			
			while(cnt == 0 ) {
				char lc = str.charAt(left);
				map[lc]++;
				if(map[lc]>0) {
					if(right-left+1<len) {
							begin = left;
							len = right-left+1;
					}
					cnt++;
				}
				left++;
			}
			
		}
		return len == Integer.MAX_VALUE ? "": str.substring(begin,begin+len);
	}

	public static void main(String[] args) {

		String result = miniMumWindow("ADOBECODEBANC","BANC");
		System.out.print(result);
	}

}
