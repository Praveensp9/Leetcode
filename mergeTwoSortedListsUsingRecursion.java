package leetcode;

import java.util.*;

class ListNode {
     int val;
     ListNode next;
     public ListNode(int x) { val = x; }
}

public class mergeTwoSortedListsUsingRecursion {

	// Iterative Solution
	private static ListNode mergeTwoSortedLists(ListNode l1,ListNode l2) {
		
        ListNode empty = new ListNode(0);
        ListNode temp = empty;
        while(l1!=null && l2!=null){
            
            if(l1.val<l2.val){
                temp.next = l1;
                l1=l1.next;
            }
            else{
                temp.next = l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        
        if(l1!=null)
            temp.next = l1;
        else if(l2 !=null)
            temp.next = l2;
        return empty.next;
	}
	
	  // Recursive Solution
	 private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        
	      if(l1 == null )
	          return l2;
	      if(l2 == null)
	          return l1;
	      if(l1.val < l2.val){
	          l1.next=mergeTwoLists(l1.next,l2);
	          return l1;
	      }  
	      else {
	          l2.next=mergeTwoLists(l1,l2.next);
	          return l2;
	      }
	        
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode lst1 = new ListNode(1);
		ListNode lst2 = new ListNode(1);
	
		mergeTwoLists(lst1,lst2);
		mergeTwoSortedLists(lst1,lst2);

	}

}
