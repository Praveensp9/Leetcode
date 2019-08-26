package leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPostAndInorder {
	
	  
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
		
	}
	
	// Recursive Solution
    private static TreeNode build(int[] post,int s,int e,int i,HashMap<Integer,Integer> map){
        if(s>e)
            return null;
        TreeNode root = new TreeNode(post[e]);
        int index = map.get(root.val);
        int len = index - i;
        root.left = build(post,s,s+len-1,i,map);
        root.right = build(post,s+len,e-1,index+1,map);
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return build(postorder,0,postorder.length-1,0,map);
        
    }

	public static void main(String[] args) {
		

	}

}
