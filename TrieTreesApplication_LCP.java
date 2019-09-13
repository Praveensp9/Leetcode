package leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class TrieTreesApplication_LCP {
	
	private static TrieNode head = new TrieNode();
	
	private static class TrieNode{
		
		Map<Character,TrieNode> node = new HashMap<>();
		boolean isLeaf = false;
		public TrieNode() {
			
		}
	}
	
	private static void insertToTrieNode(TrieNode head, String str) {
		
		TrieNode curr = head;
		
		for(int i=0;i<str.length();i++) {
			
			char c = str.charAt(i);
			if(!curr.node.containsKey(c))
				curr.node.put(c, new TrieNode());
			curr = curr.node.get(c);
		}
		curr.isLeaf = true;
	}
	
	private static String searchLongestCommonPrefix(TrieNode head) {
		StringBuilder sb = new StringBuilder();
		
		TrieNode curr = head;
		while(curr != null && !curr.isLeaf && curr.node.size() == 1) {
			
			Iterator<Map.Entry<Character,TrieNode>> itr = curr.node.entrySet().iterator();
			
			Map.Entry<Character,TrieNode> map = itr.next();
			sb.append(map.getKey());
			curr = map.getValue();
		}
		return sb.toString();
	}
	
	
	private static String longestCommonPrefix(String[] strs) {
		
		for(String str : strs)
			insertToTrieNode(head,str);
		
		
		return searchLongestCommonPrefix(head);
	}

	private static TrieNode searchPrefix(String prefix) {
		
		TrieNode  curr = head;
		for(int i=0;i<prefix.length();i++) {
			
			char c = prefix.charAt(i);
			if(curr.node.containsKey(c)) {
				curr = curr.node.get(c);
			}
			else
				return null;;
		}
		return curr;
		
	}
	public static void main(String[] args) {
			
		String[] strs = new String[] {"abcdefg","abcxefg","abcrgth","abcd","praveen","computer","acdf","ab","sdfg"};
		String prefix = "abc";
		String common = longestCommonPrefix(strs);
		System.out.println(common);
		
		TrieNode trie = searchPrefix(prefix);
		System.out.println(trie.isLeaf);
		
	}

}
