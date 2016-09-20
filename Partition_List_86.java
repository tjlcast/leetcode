package Algorithms;

public class Partition_List_86 {

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
class Solution_Partition_List_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode nullNode = new ListNode(-1) ;
        ListNode tempNode00 = new ListNode(-1) ;
        tempNode00.next = head ;
        head = tempNode00 ;
        
        ListNode p = head ; // x >= x
        ListNode q = nullNode ; // < x
        
        while(p != null) {
            while(p.next != null && p.next.val < x) {
                q.next = p.next ;
                q = q.next ;
                p.next = p.next.next ;
            }       
            p = p.next ;
        }
        q.next = null ;
        
        p = head ;
        q = nullNode ;
        while(q.next != null) {
            q = q.next ;
        }
        q.next = head.next ;
        
        return nullNode.next ;
    }
}