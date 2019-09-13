package leetcode;

public class ReverseLinkedList {
	
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
		

	}

}
