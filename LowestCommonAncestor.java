package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.InOrderSuccessorBST.TreeNode;


public class LowestCommonAncestor {
	
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
	
	
	private static int LowestCommonAncestorBST(TreeNode root,TreeNode p,TreeNode q) {
		
		int ancestor = root.val;
		
		if(p.val<ancestor && q.val<ancestor)
			return LowestCommonAncestorBST(root.left,p,q);
		else if(p.val>ancestor && q.val > ancestor)
			return LowestCommonAncestorBST(root.right,p,q);
		else
			return root.val;

	}
	
	// One solution for the binary tree problem is 
	// Find all the nodes in the path of the gives two nodes
	// example   3
	//			/ \
	//	       6   8
	//	      / \   \          2,5 == > 6
	//	     2  11   13        2 -- > 3,6,2
	//	       /  \   /        5 -- > 3,6,11,5
	//	      9    5  7
	
	// Other Solution is given below with T.C : O(n) and S.C: O(1)
	private static TreeNode LowestCommonAncestorBT(TreeNode root,TreeNode p,TreeNode q) {
		
		
		if(root == null)
			return null;
		
		if(root == p || root==q)
			return root;
		
		TreeNode left = LowestCommonAncestorBT(root.left,p,q);
		TreeNode right = LowestCommonAncestorBT(root.right,p,q);
		
		
		if(left !=null && right != null)
			return root;
		
		return left!= null ? left:right;
		
	}
	
	
	 /*function to insert element in binary tree */
   private static void insertBT(TreeNode root, Integer key) 
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
               temp.right = node;
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
	
	
	private static void insert(TreeNode root,int val) {
		
		TreeNode cur = root;
		TreeNode parent  = null;
		while(cur != null) {
			parent = cur;
			
			if(cur.val > val)
				cur = cur.left;
			else
				cur = cur.right;
			
		}
		if(parent.val > val)
			parent.left = new TreeNode(val);
		else
			parent.right = new TreeNode(val);
		
	}
	
	private static TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		
		insert(root,val);
		return root;
	}
	
   
	public static void main(String[] args) {
		
		
		TreeNode root= new TreeNode(3);
		
		insertBT(root,5);
		insertBT(root,1);
		insertBT(root,6);
		insertBT(root,2);
		insertBT(root,0);
		insertBT(root,8);
		insertBT(root,null);
		insertBT(root,null);
		insertBT(root,7);
		insertBT(root,4);

		
		TreeNode ans = LowestCommonAncestorBT(root,root.left,root.left.right.right);
		System.out.println(ans.val);

		TreeNode root1=  null;
		
		root1 = insertIntoBST(root1,9);
		root1 = insertIntoBST(root1,5);
		root1 = insertIntoBST(root1,16);
		root1 = insertIntoBST(root1,4);
		root1 = insertIntoBST(root1,13);
		root1 = insertIntoBST(root1,2);
		root1 = insertIntoBST(root1,3);


		int ans1 = LowestCommonAncestorBST(root1,root1.left.left,root1.left.left.left.right);
		System.out.println(ans1);
		
	}

}
