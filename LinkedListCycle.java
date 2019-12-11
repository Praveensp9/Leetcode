package leetcode;


public class LinkedListCycle {
	
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
	
	
	private static boolean hasCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next!=null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast == slow)
				return true;
			
		}
		
		return false;
	}
	
	private static ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null)
			return null;
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
			 
			if(slow == fast) {
				ListNode slow2 = head;
				
				while(slow2!=slow) {
					slow2=slow2.next;
					slow = slow.next;
				}
					
				return slow;
			}
		}
		
		return null;
		
	}

	public static void main(String[] args) {
		
		ListNode list = new ListNode();
		ListNode head = new ListNode(9);
		head = list.insert(head, 3);
		head = list.insert(head, 7);
		head = list.insert(head, 1);
		head = list.insert(head, 8);
		ListNode curr = head;
		ListNode cur = head;
		
		while(curr.next != null) {
			curr= curr.next.next;
			cur=cur.next;
		}
		curr.next = cur;
		
		boolean cycle = hasCycle(head);
		System.out.println(cycle);
		
		ListNode cycleNode = detectCycle(head);
		System.out.println(cycleNode.val);

	}

}
