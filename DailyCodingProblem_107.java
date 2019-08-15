package leetcode;

import java.util.*;

final class Node {
     int val;
     Node left;
     Node right;

    public Node(int data) {
        this.val = data;
    }
}

public class DailyCodingProblem_107 {
	
	private static List<List<Integer>> levelOrder(Node root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		Queue<Node> q= new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			
			List<Integer> temp = new ArrayList<>();
			int n = q.size();
			for(int i=0;i<n;i++) {
				Node node = q.poll();
				temp.add(node.val);
				
				if(node.left != null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
			}
			res.add(temp);
		}
		
		return res;
	}
	
	private static List<Node> printTreeLevelWise(Node root) {
		
		List<Node> res = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			res.add(node);
			
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);

		}
		
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Node two = new Node(2);
			Node nine = new Node(9);
	        Node ten = new Node(10);
			two.left = nine;
	        two.right = ten;

	        Node four = new Node(4);
	        Node five = new Node(5);

	        Node three = new Node(3);
	        three.left = four;
	        three.right = five;
	        

	        Node root = new Node(1);
	        root.left = two;
	        root.right = three;
	        List<Node> lst = printTreeLevelWise(root);
	        Iterator<Node> ite = lst.iterator();
	        while(ite.hasNext()) {
	        	System.out.print(ite.next().val + "  ");
	        }
	        System.out.println();
	        
	        List<List<Integer>> res =  levelOrder(root);
	        
	        Iterator<List<Integer>> t = res.iterator();
	        while(t.hasNext()) {
		        Iterator<Integer> loop = t.next().iterator();
		        while(loop.hasNext())
		        	System.out.print(loop.next() + "  ");
		        System.out.println();
	        }
	}

}
