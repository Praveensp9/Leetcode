package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeClass {
	
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
		
		TreeNode root= new TreeNode(1);
		
		insert(root,2);
		insert(root,3);
		insert(root,4);
		insert(root,5);
		insert(root,null);
		insert(root,6);
		
		List<TreeNode> res = printTreeLevelWise(root);
		
		for(TreeNode i:res)
			if(i == null)
				System.out.print("null ");
			else
				System.out.print(i.val+" ");
		
		System.out.println();
	}

}
