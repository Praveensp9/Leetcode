package leetcode;

import java.util.LinkedList;
import java.util.*;




public class kthSmallestElementInaBST {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
		
	}
	
	private static int kthsmallestIterative(TreeNode root,int k) {
		 LinkedList<TreeNode> stack  = new LinkedList<TreeNode>();
	        while(true){
	            
	            while(root != null)
	            {
	                stack.add(root);
	                root = root.left;
	            }
	            
	            root = stack.removeLast();
	            if(--k == 0)
	               return root.val;
	            root = root.right;
	        }
	}
	
	
	private static void kthSmallestElement(TreeNode root,PriorityQueue<Integer> pq,int k) {
		
		if(root == null)
			return ;
		
		kthSmallestElement(root.left,pq,k);
		pq.add(root.val);
		if(pq.size()>k)
			pq.remove();
		kthSmallestElement(root.right,pq,k);
		
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		 PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
		            new Comparator<Integer> () {
		            public int compare(Integer a, Integer b) {
		               return b - a;
		            }
		          }  
		        );
		kthSmallestElement(root,pq,3);
		System.out.println(pq.poll());
		kthsmallestIterative(root,4);
	}

}
