package leetcode;

public class SwapNodesInPairs_LC24 {
	
private static class ListNode{
		
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
		public ListNode() {
		
		}
		
		public  ListNode insert(ListNode list,int val) {
			
			ListNode new_node = new ListNode(val);
			new_node.next = null;
			
			if(list == null)
				list = new_node;
			else {
				ListNode temp = list;
				while(temp.next != null)
					temp = temp.next;
				temp.next = new_node;
			}
			
			return list;
		}
		
		private  void printlist(ListNode list){
			ListNode node = list;
	        System.out.println("LinkedList");
	        
	        while(node.next!=null){
	            System.out.print(node.val+" -> ");
	            node = node.next;
	        }
	        System.out.println(node.val);
	    }
	}	
	 
	 // Recursive Solution
	 
	 private static ListNode SwapNodesRecursive(ListNode head) {
		 
		 if(head == null || head.next == null)
			 return head;
		 
		 ListNode p1 = head;
		 ListNode p2 = head.next;
		 ListNode p3 = head.next.next;
		 
		 p2.next = p1;
		 p1.next = p3;
		 
		 if(p3 != null)
			 p1.next = SwapNodesRecursive(p3);
		return p2;
	 }
	
	private static ListNode SwapNodes(ListNode head) {
		
		
		if(head == null || head.next == null)
			return head;
		
		ListNode new_node = new ListNode(0);
		new_node.next = head;
		ListNode prev = new_node;
		ListNode cur = head;
		
		while(prev.next != null && cur.next != null) {
			
			prev.next = cur.next;
			cur.next = cur.next.next;
			prev.next.next = cur;
			prev=cur;
			cur=prev.next;
		}
		
		return new_node.next;
		
	}

	public static void main(String[] args) {			
			ListNode list = new ListNode();
			ListNode head = new ListNode(9);
			head = list.insert(head, 7);
			head = list.insert(head, 10);
			head = list.insert(head, 1);
			head = list.insert(head, 8);
			
			list.printlist(head);
			
			ListNode root = SwapNodes(head);
			
			list.printlist(root);
			

	}

}
