package leetcode;



public class SwapNodesInPairs_LC24 {
	
	
	 public static class LinkedList {
		     int val;
		     LinkedList next;
		     LinkedList(int x) { this.val = x; }
	 }
	
	private static LinkedList SwapNodes(LinkedList head) {
		
		
		if(head == null || head.next == null)
			return head;
		
		LinkedList new_node = new LinkedList(0);
		new_node.next = head;
		LinkedList prev = new_node;
		LinkedList cur = head;
		
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


	}

}
