package Algorithms;

public class Reverse_Linked_List_II_92 {

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
class Solution_Reverse_Linked_List_II_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode nullNode = new ListNode(-1) ;
        nullNode.next = head ;
        head = nullNode ;
        ListNode p = head ;
        
        int step = 1 ;
        while(p.next != null) {
            if(step == m) {
                ListNode q = p.next ;
                int in_step = step ;
                ListNode temp_root = null ;
                ListNode temp_bottom = q ;
                while(in_step <= n) {
                    ListNode temp_node = q ;
                    q = q.next ;
                    
                    temp_node.next = temp_root ;
                    temp_root = temp_node ;
                    
                    in_step++ ;
                }
                
                // p temp_root temp_bottom q
                p.next = temp_root ;
                temp_bottom.next = q ;
                break ;
            }
            
            step++ ;
            p = p.next ;
        }
        return head.next ;
    }
}