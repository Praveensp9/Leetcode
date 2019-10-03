package leetcode;

public class KnightProbabilityInChessBoard {
	
	private static double knightProbability(int N,int K,int r,int c) {
		
		double[][] cur = new double[N][N];
		cur[r][c] = 1;
		int[] dx = {1,1,-1,-1,2,2,-2,-2};
	    int[] dy = {2,-2,2,-2,1,-1,1,-1};
		for(int k=0;k<K;k++) {
			double[][] pre = cur;
			cur = new double[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					 
					for(int cnt=0;cnt<8;cnt++) {
						
						int nx = i+ dx[cnt];
						int ny = j+ dy[cnt];
						
						if(nx>=0 && nx<N && ny>=0 && ny<N)
							cur[nx][ny] += pre[i][j]*0.125;
					}
				}
			}
			
		}
		
		double res = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                res += cur[i][j];
            }
        }
        return res;
		
	}

	public static void main(String[] args) {
		double ans = knightProbability(5,2,1,1);
		System.out.println(ans);
	}

}
