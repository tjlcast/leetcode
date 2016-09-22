/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public void deleteNode(ListNode node) {
        while(true) {
            node.val = node.next.val ;
            if(node.next.next == null) break ;
            node = node.next ;
        }
        node.next = null ;
    }
}
