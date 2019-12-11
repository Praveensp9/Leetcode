package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class LC272_ClosestToBinarySearchTreeValue {
	
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
	
	
	 /*function to insert element in binary tree */
    private static void insert(TreeNode temp, int key) 
    { 
        Queue<TreeNode> q = new LinkedList<>(); 
        q.add(temp); 
       
        // Do level order traversal until we find 
        // an empty place.  
        while (!q.isEmpty()) { 
            temp = q.peek(); 
            q.remove(); 
       
            if (temp.left == null) { 
                temp.left = new TreeNode(key); 
                break; 
            } else
                q.add(temp.left); 
       
            if (temp.right == null) { 
                temp.right = new TreeNode(key); 
                break; 
            } else
                q.add(temp.right); 
        }
    } 
	
	 private static void traversal(PriorityQueue<Integer> pq, TreeNode root, double target, int k) {
	        if(root == null)
	            return;
	        if(pq.size() < k) 
	            pq.offer(root.val);
	        else {
	            if(Math.abs(target - pq.peek()) > Math.abs(target - root.val)) {
	                pq.offer(root.val);
	                pq.poll();
	            }
	        }
	        traversal(pq, root.left, target, k);
	        traversal(pq, root.right, target, k);
	 }
	    
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {
         PriorityQueue<Integer> pq = new PriorityQueue((x, y) -> 
                           Double.compare(new Double(Math.abs(target - (int)y)), 
                           new Double(Math.abs(target - (int)x)))); 
        
        
        traversal(pq, root, target, k);
        List<Integer> lst = new ArrayList<>(pq);
        return lst;
    }

	public static void main(String[] args) {
		
		TreeNode root= new TreeNode(1);
		
		insert(root,2);
		insert(root,3);
		insert(root,4);
		insert(root,5);
		
		List<Integer> res = closestKValues(root,0.1,2);
		System.out.println(res);
 		

	}

}
