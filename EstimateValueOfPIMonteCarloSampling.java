package leetcode;

public class EstimateValueOfPIMonteCarloSampling {

	private static double piValue() {
		
		int k=0;
		int n=10000;
		double x;
		double y;
		for(int i=0;i<n;i++) {
			
			 x = Math.random();
			 y = Math.random();
			
			if(x*x+y*y <=1)
				k++;
		}
		
		double pi = 4. * k/n;
		return pi;
	}
	public static void main(String[] args) {
		double value = piValue();
		System.out.print(value);
    
	}

}
