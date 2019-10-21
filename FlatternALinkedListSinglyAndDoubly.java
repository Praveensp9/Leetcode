package leetcode;

public class FlatternALinkedListSinglyAndDoubly {
	
	private static class SinglyNode{
		
		private static int val;
		private SinglyNode next;
		private SinglyNode child;
		
		public SinglyNode(int val, SinglyNode next,SinglyNode child) {
			this.next = next;
			this.child = child;
			this.val = val;
		}
	}
	
	private static class DoublyNode{
		private static int val;
		private DoublyNode next;
		private DoublyNode prev;
		private DoublyNode child;
		
		public DoublyNode(int val, DoublyNode next,DoublyNode child,DoublyNode prev) {
			this.next = next;
			this.child = child;
			this.val = val;
			this.prev = prev;
		}
	}
	
	
	private static DoublyNode flattenDoublyLinkedList(DoublyNode head) {
		DoublyNode p = head;
		
		while(p!=null) {
			 if(p.child == null) {
				 p = p.next;
				 continue;
			 }
			 
			 DoublyNode temp = p.child;
			 while(temp.next != null)
				 temp = temp.next;
			 
			 temp.next = p.next;
			 if(p.next != null)
				 p.next.prev = temp;
			 p.next = p.child;
			 p.child.prev = p;
			 p.child = null;
		}
		return head;
	}
	private static SinglyNode flattensinglyLinkedList(SinglyNode head) {
		
		return head;
	}

	public static void main(String[] args) {

	}

}
