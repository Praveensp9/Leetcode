package leetcode;

import java.util.LinkedList;
import java.util.*;
import java.util.stream.Collectors;

public class DailyCodingProblem_22 {
	
	
	private static List<String> problem22(List<String> lst, String str) {
		
		List<String> res = new ArrayList<>(); 
		Set<String> words = lst.stream().collect(Collectors.toSet());
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<str.length();i++) {
//			
//			sb.append(str.charAt(i));
//			String s = sb.toString();
//			if(words.contains(s)) {
//				//System.out.println(s);
//				res.add(s);
//				words.remove(s);
//				sb = new StringBuilder();
//				i=0;
//			}
//			
//		}
//		
//			
		res = splitWords(words,str);
		return res;
		
	}
	
	public static List<String> splitWords(Set<String> words, String str) {
		
        Deque<String> queue = new LinkedList<>();
        splitWords(queue, words, str, 0);
        return queue.isEmpty() ? null : new ArrayList<>(queue);
    }
	
	private static boolean splitWords(Deque<String> queue, Set<String> words, String str, int offs) {
        if (offs >= str.length())
            return true;

        for (String word : words) {
            if (!str.startsWith(word, offs))
                continue;

            queue.addLast(word);

            if (splitWords(queue, words, str, offs + word.length()))
                return true;

            queue.removeLast();
        }

        return false;
    }

	public static void main(String[] args) {
			
			List<String> lst = new ArrayList<>(); 
			lst.add("a");
			lst.add("aa");
			lst.add("aaa");
			lst.add("aaa");
			lst.add("aaaaa");
					
			String str = "aaaaab";
			List<String> ans = problem22(lst,str);
			
			Iterator<String> ite = ans == null ? null:  ans.iterator();
			if(ite != null)
				while(ite.hasNext()) {
					System.out.print(ite.next() + ",");
				}
			else
				System.out.println("Null");

	}

}
