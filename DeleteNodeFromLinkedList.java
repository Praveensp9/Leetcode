package leetcode;

public class DeleteNodeFromLinkedList {

	private static void deleteNode(ListNode node) {
		
		ListNode cur = null;
		
		while(node.next != null) {
			 
			node.val = node.next.val;
			cur = node;
			node = node.next;
		}
		
		cur.next = null;
		
	}
	public static void main(String[] args) {
		
		ListNode node = new ListNode(9);
		ListNode one = new ListNode(1);
		ListNode eight = new ListNode(8);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		node.next = one;
		one.next = eight;
		eight.next = four;
		four.next = five;
		five.next = null;
		
		ListNode cur = node;
		while(cur != null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
		
		System.out.println();
		deleteNode(eight);
		
		cur = node;
		while(cur != null) {
			System.out.print(cur.val + ",");
			cur = cur.next;
		}
		
		
	}

}
