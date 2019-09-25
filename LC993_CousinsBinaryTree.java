package leetcode;

public class LC993_CousinsBinaryTree {
	
	static class TreeNode{
		
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			this.val = x;
		}
	}
	
	private static int lx = -1;
	private static int ly = -1;
	private static TreeNode px = null;
	private static TreeNode py = null;
	
	private static void cousins(TreeNode root,int x,int y,int level,TreeNode parent) {
		
		if(root != null) {
			if(root.val == x) {
				lx = level;
				px = root;
			}
			if(root.val == y) {
				ly = level;
				py = root;
			}
			
			cousins(root.left,x,y,level+1,root);
			cousins(root.right,x,y,level+1,root);	
		}
	}
		
	private static boolean isCousins(TreeNode root, int x, int y) {
		
		
		
		
		if(lx == ly && px != py)
			return true;
		return false;  
	}

	public static void main(String[] args) {

	}

}
