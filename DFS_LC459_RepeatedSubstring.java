package leetcode;

public class DFS_LC459_RepeatedSubstring {
	
	private static boolean repeatedSubstringPattern(String s) {
		
		String prefix = "";
		int n=s.length();
		boolean found = false;
		for(int i=0;i<n-1;i++) {
			
			String sub = Character.toString(s.charAt(i));
			prefix = prefix  + sub;
			found  = dfs(s.substring(i+1),prefix);
			if(found)
				return true;
			
		}
		return false;
	}
	
	
	private static boolean dfs(String str,String suf) {
		System.out.println(str);
		
		if(str.length()<=0 || str == "")
			return true;
		if(str.length()<suf.length())
			return false;
		if(str.substring(0,suf.length()).equals(suf))
			return dfs(str.substring(suf.length()),suf);
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = repeatedSubstringPattern("ababab");
		System.out.println(res);
	}

}
