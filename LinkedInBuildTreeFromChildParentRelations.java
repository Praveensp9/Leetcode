package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LinkedInBuildTreeFromChildParentRelations {
	
	private static class Relation {
	    Integer parent;
	    Integer child;
	    boolean isLeft;

		    public Relation(Integer child, Integer parent, boolean left) {
		        this.parent = parent;
		        this.child = child;
		        this.isLeft = left;

	    }
	}
	
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
	
	
	public static TreeNode buildTree(List<Relation> relations) {
		TreeNode root = null;
		Map<Integer, TreeNode> map = new HashMap<Integer,TreeNode>();
		for(Relation relation: relations){
//			System.out.print(relation.parent + " ");
//			System.out.println(relation.child);
			if(relation.parent==null) {//we met root node
				if(!map.containsKey(relation.child)) map.put(relation.child, new TreeNode(relation.child));
				root = map.get(relation.child);
			}
			else if(relation.child==null){//we met leave node
				if(!map.containsKey(relation.parent)) map.put(relation.parent, new TreeNode(relation.parent));								
			}
			else{
				if(!map.containsKey(relation.parent)&&!map.containsKey(relation.child)){
					TreeNode parentNode = new TreeNode(relation.parent);
					TreeNode childNode = new TreeNode(relation.child);
					if(relation.isLeft) parentNode.left = childNode;
					else parentNode.right = childNode;
					map.put(relation.parent, parentNode);
					map.put(relation.child, childNode);
				}
				else if(map.containsKey(relation.parent)&&map.containsKey(relation.child)){
					if(relation.isLeft) map.get(relation.parent).left = map.get(relation.child);
					else map.get(relation.parent).right = map.get(relation.child);
				}
				else if(map.containsKey(relation.parent))	{
					TreeNode childNode = new TreeNode(relation.child);
					map.put(relation.child, childNode);
					if(relation.isLeft) map.get(relation.parent).left = childNode;
					else map.get(relation.parent).right = childNode;
				}
				else{
					TreeNode parentNode = new TreeNode(relation.parent);
					map.put(relation.parent, parentNode);
					if(relation.isLeft) parentNode.left = map.get(relation.child);
					else parentNode.right = map.get(relation.child);
				}				
			}
				
		}
		return root;
	}

	public static void main(String[] args) {
		
		List<Relation> data = new LinkedList<>();
        data.add(new Relation(15, 20, true));
        data.add(new Relation(19, 80, true));
        data.add(new Relation(17, 20, false));
        data.add(new Relation(16, 80, false));
        data.add(new Relation(80, 50, false));
        data.add(new Relation(50, null, false));
        data.add(new Relation(20, 50, true));

        TreeNode root = buildTree(data);
        
        List<TreeNode> res = printTreeLevelWise(root);
		
		for(TreeNode i:res)
			if(i == null)
				System.out.print("null ");
			else
				System.out.print(i.val+" ");
		
		System.out.println();
        

	}

}
