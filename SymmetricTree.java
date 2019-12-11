package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class SymmetricTree {

	
	private static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
			
		}
		TreeNode(int x){
			this.val = x;
		}
		
	}
	
	 /*function to insert element in binary tree */
    private static void insert(TreeNode root, Integer key) 
    { 
    	TreeNode node = null;
    	if(key != null)
    		node = new TreeNode(key); 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root); 
       
        // Do level order traversal until we find 
        // an empty place.  
        while (!q.isEmpty()) { 
            TreeNode temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = node;
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right =  node;
                break; 
            } else
                q.add(temp.right); 
        }
    } 
	
	// Iterative Solution
	private static boolean helperIterative(TreeNode root) {
		 Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        q.add(root);
	        
	        while(!q.isEmpty()){
	            TreeNode l = q.poll();
	            TreeNode r = q.poll();
	            if( l == null && r == null) 
	                continue;
	            if(l == null || r == null)
	                return false;
	            
	            if(l.val != r.val)
	                return false;
	            
	            q.add(l.left);
	            q.add(r.right);
	            q.add(l.right);
	            q.add(r.left);
	        }
	        return true;
	}
	
	// Recursive Solution
	private static boolean helper(TreeNode l,TreeNode r) {
		
		if(l == null && r == null)
			return true;
		if(l == null || r == null)
			return false;
		
		if(l.val != r.val)
			return false;
		
		return helper(l.left,r.right) && helper(l.right, r.left);
		
	}
	private static boolean Symmetric(TreeNode root) {
		
		return helper(root,root);
	}

	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		
		insert(root,2);
		insert(root,2);
		insert(root,3);
		insert(root,4);
		insert(root,4);
		insert(root,3);
		
		boolean ans = Symmetric(root);
		System.out.println(ans);
		
	}

}
