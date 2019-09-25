package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC426_ConvertABinarySearchTreeIntoCircularDLL {
	
	
static class TreeNode{ 
		
		int val;
		TreeNode left;
		TreeNode right;
		private TreeNode(){
			
		}
		TreeNode(int x){
			this.val = x;
		} 
	}
	
	private static TreeNode treeToDLL(TreeNode root) {
		
		if(root == null)
			return root;
		TreeNode pre = null;
		TreeNode head = null;
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		while(!stack.isEmpty() && root != null) {
			
			while(root != null) {
				stack.push(root);
				root= root.left;
			}
			
			root = stack.pop();
			if(pre == null)
				head = root;
			else {
				pre.right = root;
				root.left = pre;
			}
			
			pre = root;
			root = root.right;
		}
		
		pre.right = head;
		head.left = pre;
		
		return head;
		
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(4);
		TreeNode two = new TreeNode(2);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		
		root.left = two;
		root.right = five;
		two.left = one;
		two.right = three;
		
		System.out.println(treeToDLL(root));
		
	}

}
