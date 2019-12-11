package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC1110_DeleteNodesAndReturnForest {
	
	 private static List<TreeNode> forest = new ArrayList<>();
	 private static Set<Integer>   delSet = new HashSet<>();
	    
	
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
    private static void dfs(TreeNode node, TreeNode prev) {
        if (node == null) {
            return;
        }

        dfs(node.left, node);
        dfs(node.right, node);

        if (delSet.contains(node.val)) {
            if (prev != null) {
                if (prev.left == node) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
            }

            if (node.left != null) {
                forest.add(node.left);
            }

            if (node.right != null) {
                forest.add(node.right);
            }
        }
    }
    
    
	
	private static List<TreeNode> deleteNodeReturnForest(TreeNode root,int[] delete){
		if (root == null) {
            return null;
        }

        // Convert to set for O(1) contains operation
        for (int num : delete) {
            delSet.add(num);
        }

        // Handle special case for root
        if (!delSet.contains(root.val)) {
            forest.add(root);
        }

        dfs(root, null);
        return forest;
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
		insert(root,6);
		insert(root,7);
		
		int[] delete = new int[] {3,5};
		List<TreeNode> nodes = deleteNodeReturnForest(root,delete);
		for(TreeNode node:nodes) {
			TreeNode curr = node;
			List<TreeNode> res = printTreeLevelWise(curr);
			
			for(TreeNode i:res)
				if(i == null)
					System.out.print("null ");
				else
					System.out.print(i.val+" ");
			System.out.println();
		}
	}

}