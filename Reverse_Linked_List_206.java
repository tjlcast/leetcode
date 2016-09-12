/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        return new Solution1().work(head) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public ListNode work(ListNode head) {
        ListNode newHead = new ListNode(-1) ;
        
        ListNode curNode = head ;
        while(curNode != null) {
            ListNode tempNode = curNode ;
            curNode = curNode.next ;
            
            tempNode.next = newHead.next ;
            newHead.next = tempNode ;
        }
        
        return newHead.next ;
    }
}
