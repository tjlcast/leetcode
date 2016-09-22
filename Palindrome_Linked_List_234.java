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
    private String __tips__ = "使用stack进行记录" ;
    
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>() ;
        
        ListNode cur = head ;
        while(cur != null) {
            stack.push(cur) ;
            cur = cur.next ;
        }
        
        cur = head ;
        while(stack.size()!=0) {
            ListNode top = stack.pop() ;
            if (cur.val != top.val) {
                return false ;
            }
            cur = cur.next ;
        }
        return true ;
    }
}
