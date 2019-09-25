package leetcode;


public class LC19_RemoveNthNodeFromEndOfLinkedList {

	static class ListNode{
		
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val = val;
		}
	}
	
	private static ListNode remove(ListNode head, int n) {
		
		ListNode curr = head;
		int len = 0;
		
		while(curr.next != null) {
			len=len+1;
			curr = curr.next;
		}
		
		int cnt = len-n; // len is total length of LinkedList - 1;
		
		if(cnt<0)
			return head.next;
		curr= head;
		
		while(cnt>0) {
			curr = curr.next;
			cnt--;
		}
		curr.next = curr.next.next;
		return head;
	}
	
	public static void main(String[] args) {

	}

}
