package leetcode;

public class LC671_SecondMinimumValueInABinaryTree {
		int min = 0;
	    long ans = Long.MAX_VALUE;
	
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
	    private  void dfs(TreeNode root){
	        if(root!=null){
	            
	            if(min<root.val && root.val<ans)
	                ans = root.val;
	            else if(min == root.val){
	                dfs(root.left);
	                dfs(root.right);
	            }
	        }    
	    }
	    
	    public int findSecondMinimumValue(TreeNode root) {
	       
	        min = root.val;
	        dfs(root);
	        return ans<Long.MAX_VALUE?(int) ans:-1;
	    }

	public static void main(String[] args) {
		

	}

}
