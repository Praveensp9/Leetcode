package leetcode;

public class ReverseLinkedList {
	
	
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
	
	private static ListNode reverseUsingIterativeMethod(ListNode head) {
		
		
		ListNode prev = null;
		ListNode next = null;
		ListNode cur = head;
		
		while(cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		 
		head = prev;
		
		return head;
	}
	
	
	
	private static ListNode reverseUsingRecusion(ListNode head) {
		
		
		
		if(head == null || head.next == null)
			return head;
		
		ListNode p = reverseUsingRecusion(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}

	public static void main(String[] args) {
		
		ListNode list = new ListNode();
		ListNode head = new ListNode(9);
		head = list.insert(head, 3);
		head = list.insert(head, 7);
		head = list.insert(head, 1);
		head = list.insert(head, 8);
		
		list.printlist(head);
		
		ListNode root = reverseUsingIterativeMethod(head);
		
		list.printlist(root);
		
//		ListNode root2 = reverseUsingRecusion(head);
//		
//		list.printlist(root2);
	}
	

}
