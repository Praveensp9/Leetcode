package leetcode;

import java.util.PriorityQueue;

// leetcode 23
public class MergeKSortedLists {
	
	
	private static ListNode merge(ListNode[] lists) {
		
		ListNode head = new ListNode(0);
		ListNode p = head;
		
		
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
		
		for(ListNode lst:lists) {
			if(lst != null) {
				q.offer(lst);
			}
		}
		
		while(!q.isEmpty()){
			
			ListNode tmp = q.poll();
			p.next = tmp;
			p=p.next;
			if(tmp.next != null)
				q.offer(tmp.next);
		}
		
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
