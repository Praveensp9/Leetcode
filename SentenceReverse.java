package leetcode;

import java.util.Stack;

public class SentenceReverse {
	
	 private static char[] reverseWords(char[] arr) {
		    String str = String.valueOf(arr);
		    String[] s = str.split(" ");
		    
		    
		    if(s.length == 0)
		      return arr;
		    
		    int l=0;
		    int r=s.length-1;
		    
		    while(l<r){
		      String ss = s[l];
		      s[l]=s[r];
		      s[r] = ss;
		      l++;
		      r--;
		    }
		    
		    int n = s.length-1;
		    int cnt=0;
		    
		    char[] cc = new char[arr.length];
		    int k=0;
		    for(String i:s)
		    {
		      if(cnt !=n)
		        i=i+" ";
		      char[] chr = i.toCharArray();
		      
		      for(char c: chr){
		        cc[k++] = c;
		      }
		      cnt++;
		    }
		    
		    
		    return cc;
	}

	public static void main(String[] args) {
		char[] inputArray = new char[] { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
		                  		 'm', 'a', 'k', 'e', 's', ' ',
		                  		 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
		
		System.out.println(inputArray);
		char[] output = reverseWords(inputArray);
		System.out.print(output);

	}

}
