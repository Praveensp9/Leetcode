package leetcode;


public class LinkedListCycle {
	
	static class ListNode{
		
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
			next = null;
		}
	}
	
	ListNode head;
	
	
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
		

	}

}
