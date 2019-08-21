package leetcode;




public class DailyCodingProblem_50 {

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode() {
			this.left = null;
			this.right = null;
			val = 0;
		}
		
		public void insert(char x) {
			TreeNode new_node = new TreeNode();
			new_node.val = x;
		}
		public void insert(int x) {
			
		}
	}
	
	// TreeNode root;
	
	private static int ExpressionEvaluation(TreeNode root) {
		
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.val;
		
		int l = ExpressionEvaluation(root.left);
		int r = ExpressionEvaluation(root.right);
		
			switch(root.val) {
				case '+':
					return l+r;
				case '-':
					return l-r;
				case '*':
					return l*r;
				case '/':
					return l/r;
				default:
					return 0;
			}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode();
		root.insert('+');
		root.insert('*');
		int asns = ExpressionEvaluation(root);
		System.out.println(asns);
	}

}
