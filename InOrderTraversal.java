package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class InOrderTraversal {
	
	private static class TreeNode{
		
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
    
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst=new ArrayList<>();
        if(root == null)
            return lst;
        inorder(root,lst);
        return lst;
    }

    private static List<Integer> inOrderIterative(TreeNode root){
    	List<Integer> inorder=new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	if(root == null)
    		return inorder;
    	
    	TreeNode cur = root;
    	while(cur != null || !stack.isEmpty()) {
    		
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
    

	
	 /*function to insert element in binary tree */
    private static void insert(TreeNode temp, int key) 
    { 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(temp); 
       
        // Do level order traversal until we find 
        // an empty place.  
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = new TreeNode(key); 
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new TreeNode(key); 
                break; 
            } else
                q.add(temp.right); 
        }
    } 
    
	
	private static List<TreeNode> printTreeLevelWise(TreeNode root) {
		
		List<TreeNode> res = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode node = queue.poll();
			res.add(node);
			
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);

		}
		
		
		return res;
	}

	
	
	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(9);
		
		insert(root,5);
		insert(root,16);
		insert(root,4);
		insert(root,13);
		insert(root,2);
		insert(root,3);
		insert(root,7);
		
//	
//		List<TreeNode> res = printTreeLevelWise(root);
//		
//		for(TreeNode i:res)
//			System.out.print(i.val+" ");
//		
//		System.out.println();
		
		List<Integer> inorder= inorderTraversal(root);
		for(int i:inorder)
			System.out.print(i+" ");

	}

}
