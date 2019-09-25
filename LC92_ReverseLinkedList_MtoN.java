package leetcode;

public class LC92_ReverseLinkedList_MtoN {
	
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		    	  val = x; 
		      }
	}
	
	private static ListNode ReverseLinkedList(ListNode head,int m,int n) {
	
		ListNode prev = null;
		ListNode next = null;
		ListNode cur = head;
		
		if(head == null)
			return head;
		
		while(m>1) {
			prev = cur;
			cur = cur.next;
			m--;
			n--;
		}
		
		ListNode con = prev;
		ListNode tail = cur;
		
		while(n>0) {
			
			next  = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
			n--;
		}
		
		if(con == null)
			head = prev;
		else
			con.next = prev;
		
		tail.next = cur;
		return head;
	}

	public static void main(String[] args) {

	}

}
