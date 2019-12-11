package leetcode;

public class ShortestDistanceBetweenWords {
	
	
	private static int shortestDistance1(String[] words,String word1,String word2) {
		
		
		int m=-1;
		int n=-1;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++) {
			
			if(word1.equals(words[i])) {
				m = i;
				if(n!=-1)
					min = Math.min(min, m-n);
			}
			else if(word2.equals(words[i])) {
				n=i;
				if(m!=-1)
					min=Math.min(min, n-m);
			}
		}
		
		return min;
	}

	public static void main(String[] args) {
		

	}

}
