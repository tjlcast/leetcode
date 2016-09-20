package Algorithms;

public class Remove_Duplicates_from_Sorted_List_II_82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
*/


class Solution_Remove_Duplicates_from_Sorted_List_II_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nullHead = new ListNode(-1) ;
        ListNode q = nullHead ;
        ListNode p = head ;
        while(p != null) {
            
            boolean is_duplicate = false ;
            while(p.next != null && p.val == p.next.val) {
                p = p.next ;
                is_duplicate = true ;
            }
            
            if(is_duplicate == false) {
                System.out.println("false") ;
                q.next = p ;
                q = q.next ;
            }
            
            p = p.next ;
        }
        q.next = null ;
        
        return nullHead.next ;
    }
}