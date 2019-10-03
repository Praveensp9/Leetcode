package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class ConstructBinaryFromPreOrderAndInOrder {
	
	static class TreeNode{
			
			int val;
			TreeNode left;
			TreeNode right;
			TreeNode(int x){
				this.val = x;
			}
			
		}
	
	// Recursive Solution
	private static TreeNode buildTree(List<Integer> preorder,int s,int e,Map<Integer,Integer> map) {
		
		if(s>e)
			return null;
		
		TreeNode root = new TreeNode(preorder.get(0));
		int val = map.get(root.val);
		preorder.remove(0);
		
		root.left = buildTree(preorder,s,val-1,map);
		root.right = buildTree(preorder,val+1,e,map);
		return root;
	}
	
	private static TreeNode construct(int[] preorder,int[] inorder) {
		
		List<Integer> pre = new ArrayList<Integer>();
		for(int i:preorder)
			pre.add(i);
		
		Map<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<inorder.length;i++)
			map.put(inorder[i], i);
		
		TreeNode root = buildTree(pre,0,inorder.length-1,map);
		return root;
			
	}
	
	
	// Iterative Solution
	private static TreeNode constructIterative(int[] preorder,int[] inorder) {
		
		 if (preorder.length == 0) {
	            return null;
	        }
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < inorder.length; i++) {
	            map.put(inorder[i], i);
	        }
	        
	        Stack<TreeNode> stack = new Stack<>();
	        int value = preorder[0];
	        TreeNode root = new TreeNode(value);
	        stack.push(root);
	        
	        for (int i = 1; i < preorder.length; i++) {
	            value = preorder[i];
	            TreeNode node = new TreeNode(value);
	            
	            if (map.get(value) < map.get(stack.peek().val)) {
	                stack.peek().left = node;
	            } else {
	                TreeNode parent = null;
	                while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
	                    parent = stack.pop();
	                }
	                parent.right = node;
	            }
	            stack.push(node);
	        }
	        
	        return root;
	}

	public static void main(String[] args) {

	}

}
