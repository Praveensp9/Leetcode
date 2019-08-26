package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PostOrderTraversal {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
		
	}
	
	private static List<Integer> postOrderIterative(TreeNode root){
		List<Integer> lst = new ArrayList<Integer>();
		
		if(root == null)
			return lst;
		Stack<TreeNode> stk = new Stack<>();
		Set<TreeNode> visited = new HashSet<>();
		
		stk.push(root);
		while(!stk.isEmpty()) {
			
			TreeNode cur = stk.pop();
			if(visited.contains(cur))
				lst.add(cur.val);
			else {
				stk.push(cur);
				if(cur.right != null)
					stk.push(cur.right);
				if(cur.left != null)
					stk.push(cur.left);
			}
			visited.add(cur);
			
		}
		return lst;
		
	}

	public static void main(String[] args) {
		
		

	}

}
