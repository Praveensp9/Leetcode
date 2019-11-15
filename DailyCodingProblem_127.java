package leetcode;

import java.util.*;
import java.util.LinkedList;



public class DailyCodingProblem_127 {
	
	
	// Simliar to Leetcode 2
	private static LinkedList<Integer> linkedlistsum_LC2(LinkedList<Integer> lst1,LinkedList<Integer> lst2){
		
		LinkedList<Integer> root = new LinkedList<Integer>();
		
		Iterator<Integer> it = lst1.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		int val = Integer.parseInt(sb.reverse().toString());
		
		Iterator<Integer> it1 = lst2.iterator();
		sb = new StringBuilder(); 
		while(it1.hasNext()) {
			sb.append(it1.next());
		}
		int val1 = Integer.parseInt(sb.reverse().toString());
		
		System.out.println(val + " " + val1);
		
		int res = val+val1;
		System.out.println(res);
		sb = new StringBuilder();
		int ans = Integer.parseInt(sb.append(res).reverse().toString());
		char[] ch = sb.append(res).reverse().toString().toCharArray();
		System.out.println(ans);
		
		
		return root;
		
	}
	
	
	private static ListNode linkedlistsum(ListNode lst1,ListNode lst2){
		
		ListNode head = new ListNode(0);
		ListNode curr = head;
		
		ListNode p = lst1;
		ListNode q = lst2;
		int carry = 0;
		
		while(p!=null && q!=null) {
		
			int a = p!=null ? p.val : 0;
			int b = q!=null ? q.val : 0;
			
			int sum = a+b+carry;
			carry = sum/10;
			curr.next = new ListNode(sum%10);
			curr = curr.next;
			if(p!=null)
				p=p.next;
			if(q!=null)
				q=q.next;
			
		}
		
		if(carry>0)
		{
			curr.next = new ListNode(carry);
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> lst1 = new LinkedList<>();
		lst1.add(9);
		lst1.add(7);
		System.out.println("LinkedList 1: "+ lst1);
		
		LinkedList<Integer> lst2 = new LinkedList<>();
		lst2.add(5);
		lst2.add(8);
		System.out.println("LinkedList 1: "+ lst2);
		linkedlistsum_LC2(lst1,lst2);
		
		//System.out.println(linkedlistsum(lst1,lst2));

	}

}
