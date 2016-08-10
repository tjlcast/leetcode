/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 
public class Solution {
    
    String __author__ = "tangjialiang" ; 
    
    private ListNode headNode = null ;
    
    public boolean hasCycle(ListNode head) {
        return isCycle(head) ;
    }
    
    public boolean isCycle(ListNode head) {
        if (head == null) {
            return true; 
        }
        
        headNode = head ;
        
        ListNode curNode = head ;
        while(curNode!=null) {
            if(isHead(curNode)) {
                return true ;
            }
            curNode = curNode.next ;
        }
        
        return false ;
    }
    
    private boolean isHead(ListNode node) {
        if (node == this.headNode) {
            return true ;
        }
        return false ;
    }
}
