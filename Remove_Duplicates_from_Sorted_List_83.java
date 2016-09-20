package Algorithms;

public class Remove_Duplicates_from_Sorted_List_83 {

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

class Solution_Remove_Duplicates_from_Sorted_List_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head ;
        
        while(p != null) {
            while(p.next != null && p.val == p.next.val) {
                p.next = p.next.next ;
            }
            
            p = p.next ;
        }
        
        return head ;
    }
}