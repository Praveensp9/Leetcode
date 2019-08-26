package leetcode;

public class RemoveKDigits_LC402 {
	
	 private static String removeKdigits(String num, int k) {
	        
	        if(num.length() == k)
	            return "0";
	       
	        
	        StringBuilder res = new StringBuilder(num);
	        
	        for(int i=1;i<res.length() && k>0;i++){
	            
	            
	            while(i>0 && res.charAt(i) < res.charAt(i-1) && k-->0){
	                
	                res.delete(i-1,i);
	                i--;
	            }
	            
	        }
	         
//	        System.out.println(res.toString());
//	        
//	        System.out.println(res.length()-1);
//	        
//	        System.out.println(res.length());
	        
	        while(k-->0)
	            res.delete(res.length()-1,res.length());
	        
	        
	        while(res.length()>1 && res.charAt(0)=='0')
	            res.delete(0,1);
	        
	        return res.toString();
	    
	    }

	public static void main(String[] args) {
		String res = removeKdigits("1231345",4);
		
		System.out.println(res);

	}

}
