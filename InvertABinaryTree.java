package leetcode;


import java.util.Queue;
import java.util.LinkedList;

public class InvertABinaryTree {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
		
	}
	
	// Recursive Solution to Invert a Binary tree
	private static TreeNode Invert(TreeNode root) {
		
		if(root == null)
			return root;
		
		TreeNode left = Invert(root.left);
		TreeNode right = Invert(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	
	private static TreeNode InvertIterative(TreeNode root){
		if(root == null)
			return root;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
			 
			if(cur.left != null)
				queue.add(cur.left);
			if(cur.right != null)
				queue.add(cur.right);
		}
		
		return root;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(2);
		Invert(root);

	}

}
