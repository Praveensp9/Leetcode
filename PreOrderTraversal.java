package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
		
	  static class TreeNode{
			
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x){
				this.val = x;
			}
			
		}
	
	  //Recursive Solution
	  private static List<Integer> pre = new ArrayList<>();
	  private static void traverse(TreeNode root){
        
        if(root == null)
            return;
        
        pre.add(root.val);
        traverse(root.left);
        traverse(root.right);
        
	  }
	  
	  private static List<Integer> preorderTraversal(TreeNode root) {

        traverse(root);
        return pre;
        
	  }
	  
	  // Iterative Solution
	    public List<Integer> preorderTraversalIterative(TreeNode root) {
	        
	        
	        List<Integer> preorder = new ArrayList<>();
	        if(root == null) 
	            return preorder;
	        Stack<TreeNode> stk = new Stack<TreeNode>();
	        
	        stk.push(root);
	        
	        while(!stk.isEmpty()){
	            TreeNode cur = stk.pop();
	            preorder.add(cur.val);
	            
	            if(cur.right != null){
	                stk.push(cur.right);
	            }
	            if(cur.left != null){
	                stk.push(cur.left);
	            }
	            
	        }
	        return preorder;
	 
	        
	    }

	  public static void main(String[] args) {
		

	  }

}
