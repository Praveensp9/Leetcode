package leetcode;

public class LinkedList {

	static class Node{
		
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	
	Node head;
	
	
	private static LinkedList insert(LinkedList list,int val) {
		
		Node new_node = new Node(val);
		new_node.next = null;
		
		if(list.head == null)
			list.head = new_node;
		else {
			Node temp = list.head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = new_node;
		}
		
		return list;
	}
	private static void printlist(LinkedList list){
        Node node = list.head;
        System.out.println("LinkedList");
        
        while(node.next!=null){
            System.out.print(node.val+" -> ");
            node = node.next;
        }
        System.out.println(node.val);
    }
	
	private static void insertAtFirst(LinkedList list,int val) {
		Node new_node = new Node(val);
		new_node.next = list.head;
		list.head = new_node;
		
	}
	
	private static void insertBetween(Node node,int val) {
		
		if(node == null)
			return;

		Node new_node = new Node(val);
		new_node.next = node.next;
		node.next = new_node;
		
	}
	
	private static void deleteByIndex(LinkedList list,int index) {
		Node cur = list.head;
		int cnt = 0;
		
		Node prev = null; 
		if(index == 0 && cur != null) {
			list.head = cur.next;
			cur.next = null;
		}

			
		while(cur != null) {
			if(cnt == index) {
				prev.next = cur.next;
				cur.next = null;
				break;
			}
			else {
				prev = cur;
				cur = cur.next;
				cnt++;
			}
		}
		
		if(cur == null) {
			System.out.println("List cannot be deleted. Index is greater then the size of LinkedList");
		}
			
	}
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list = insert(list,34);
		list = insert(list,45);
		list = insert(list,9);
		list = insert(list,18);
		list = insert(list,8);
		list = insert(list,14);
		list = insert(list,29);
		list = insert(list,7);
		list = insert(list,11);
		printlist(list);
		
		insertAtFirst(list,1);
		printlist(list);
		
		insertBetween(list.head.next.next, 78);
		printlist(list);
		
		deleteByIndex(list,4);
		printlist(list);
	}

}
