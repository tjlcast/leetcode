/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        return new Solution1().work(head, val) ;
    }
}

class Solution1 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    
    public ListNode work(ListNode head, int val) {
        ListNode tempHead = new ListNode(-1) ;
        tempHead.next = head ;
        head = tempHead ;
        
        ListNode curNode = head ;
        while(curNode.next != null) {
            
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next ;
            } else {
                curNode = curNode.next ;
                if (curNode == null) {
                    break ;
                }
            }
        }
        
        return head.next ;
    }
}
