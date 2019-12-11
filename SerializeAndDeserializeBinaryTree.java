package leetcode;

import java.util.*;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
	
	
	private static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
			
		}
		TreeNode(int x){
			this.val = x;
			left = null;
			right = null;
		}
		
	}
	
	
	 /*function to insert element in binary tree */
    private static TreeNode insert(TreeNode root, Integer key)
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
            }
            else
                q.add(temp.left); 
       
            if (temp.right == null) { 
            	temp.right = node;
                break; 
            } 
            else
                q.add(temp.right); 
        }
        
        return root;
    } 
    
	private static List<TreeNode> printTreeLevelWise(TreeNode root) {
		
		List<TreeNode> res = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode dummy = null;
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

	    // Encodes a tree to a single string.
	    private static String serialize(TreeNode root) {
	    	
	        if(root == null) 
	        	return "null";
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        StringBuilder sb = new StringBuilder();
	        
	        // use tree level order traversal to serialize the tree
	        while(!q.isEmpty()) {
	            TreeNode n = q.poll();
	            if(n == null) {
	                sb.append("null,");
	            } else{
	                sb.append(n.val + ",");
	                q.add(n.left);
	                q.add(n.right);
	            }
	        }
	        sb.deleteCharAt(sb.length()-1);
	        return sb.toString().trim();
	        
	    }

	    // Decodes your encoded data to tree.
	  private static TreeNode deserialize(String data) {
		  	if(data == null || data.isEmpty() || data.equals("null"))
	            return null;
		  	
	        String[] vals = data.split(",");
	        if(vals.length == 0) 
	        	return null;
	        
	        Queue<TreeNode> q = new LinkedList<>();
	        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
	        
	        q.add(root);
	        TreeNode p = null;
	        String val;
	      
	        for(int i = 1; i < vals.length; ) {
	            p = q.poll();
	            val = vals[i++];
	            if(val.equals("null")) {
	                p.left = null;
	            } else {
	                p.left = new TreeNode(Integer.valueOf(val));
	                q.add(p.left);
	            }
	            if(i < vals.length) {
	                val = vals[i++];
	                if(val.equals("null")) {
	                    p.right = null;
	                } else {
	                    p.right = new TreeNode(Integer.valueOf(val));
	                    q.add(p.right);
	               }
	            }
	        }
	        return root;
	    }
	  


	public static void main(String[] args) {
		
			TreeNode root= new TreeNode();
			TreeNode left= new TreeNode();
			TreeNode right= new TreeNode();
			TreeNode left1= new TreeNode();
			TreeNode right1= new TreeNode();
			
//			root = insert(root,2);
//			root = insert(root,3);
//			root = insert(root,null);
//			root = insert(root,null);
//			root = insert(root,4);
//			root = insert(root,5);
			
			root.val = 1;
			
			root.left = left;
			left.val = 2;
			root.right = right;
			right.val = 3;
			
			root.left.left = null;
			root.left.right = null;
			
			root.right.left = left1;
			left1.val = 4;
			root.right.right = right1;
			right1.val = 5;
			
			
			List<TreeNode> res = printTreeLevelWise(root);
			
			for(TreeNode i:res)
				if(i == null)
					System.out.print("null ");
				else
					System.out.print(i.val+" ");
			
			System.out.println();
			
			
			String str = serialize(root);
			System.out.println(str);
			TreeNode  head = deserialize(str);
			
			List<TreeNode> res1 = printTreeLevelWise(root);
			
			for(TreeNode i:res1)
				if(i == null)
					System.out.print("null ");
				else
					System.out.print(i.val+" ");
			
			System.out.println();

	}

}
