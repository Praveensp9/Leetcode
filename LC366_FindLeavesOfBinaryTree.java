package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC366_FindLeavesOfBinaryTree {
	
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
	
	 private static void findLeavesEnd(TreeNode root,TreeNode parent,List<Integer> list){
	        if(root == null)
	            return;
	        if(root.left != null || root.right != null){
	            findLeavesEnd(root.left,root,list);
	            findLeavesEnd(root.right,root,list);
	        }
	        else{
	            list.add(root.val);
	            if(root == parent.left){
	                parent.left = null;
	            }
	            else if(root == parent.right){
	                parent.right= null;
	            }
	        }
	    
	    }
		
	private static List<List<Integer>> findLeaves(TreeNode root){
		  List<List<Integer>> lists = new ArrayList<>();
	        if(root == null)
	            return lists;
	        
	        List<Integer> list = null;
	        
	        while(root!=null && (root.left != null || root.right != null)){
	            list = new ArrayList<>();
	            findLeavesEnd(root,null,list);
	            lists.add(list);
	        }
	        
	        // root append at last
	        list = new ArrayList<>();
	        list.add(root.val);
	        lists.add(list);
	        return lists;
	}
	
	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(1);
		
		insert(root,2);
		insert(root,3);
		insert(root,4);
		insert(root,5);
		
		List<List<Integer>>  res = findLeaves(root);
		System.out.println(res);

	}

}
