/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        Solution_1 sol = new Solution_1() ;
        return sol.work(head) ;
    }
}


class Solution_1 {
    
    private String __title__ = "Insertion_Sort_List_147.java" ;
    private String __V__ = "success_V" ;
    
    public Solution_1() {} 
    
    public ListNode work(ListNode head) {
        ListNode workNode = head ;
        ListNode resultHead = new ListNode(-1) ;
        
        while(workNode!=null) {
            ListNode item = workNode ;
            workNode = workNode.next ;
            
            item.next = null ;  // 减除resultset与sheng xiashengxia
            insertIntoList(item, resultHead) ;
        }
        return resultHead.next ;
    }
    
    private void insertIntoList(ListNode node, ListNode head) {
        int value = node.val ;
        ListNode curNode = head ;
        while (curNode.next != null) {
            if (curNode.next.val > value) {
                node.next = curNode.next ;
                curNode.next = node ;
                return ;
            }
            curNode = curNode.next ;
        }
        
        curNode.next = node ;
    }
}
