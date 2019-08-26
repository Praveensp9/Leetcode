package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class InOrderTraversal {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
		
	}
	
	// Recursive Solution 
	private static void inorder(TreeNode root,List<Integer> lst){
        if(root == null)
            return;
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }
    
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst=new ArrayList<>();
        if(root == null)
            return lst;
        inorder(root,lst);
        return lst;
    }

    private List<Integer> inOrderIterative(TreeNode root){
    	List<Integer> inorder=new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	if(root == null)
    		return inorder;
    	
    	TreeNode cur = root;
    	while(cur != null || stack.isEmpty()) {
    		
    		while(cur != null) {
    			stack.push(cur);
    			cur = cur.left;
    		}
    		
    		cur = stack.pop();
    		inorder.add(cur.val);
    		cur = cur.right;
    		
    	}

    	return inorder;
    }
	public static void main(String[] args) {

	}

}
