package leetcode;

public class FindCelebrity {
	private static int[][] celebrity = new int[][] {
									 {0,0,0,1},
									 {0,0,1,1},
									 {0,1,0,1},
									 {0,0,0,0}
									};

	private static int celebrity(int n) {
		int a = 0;
		int b = n-1;
		
		while(a<b) {
			if(celebrity[a][b] == 1)
				a++;
			else
				b--;
		}
		
		for(int i=0;i<n;i++) {
			
			if(a!=i && (celebrity[a][i] == 1 || celebrity[i][a] == 0))
				return -1;
		}
		return a;
		
	}
	
	public static void main(String[] args) {
		
		int ans = celebrity(4);
		System.out.println(ans);
		

	}

}
