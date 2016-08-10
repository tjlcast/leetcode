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
    private String __V__ = "test_V" ;
    
    public ListNode sortList(ListNode head) {
        Solution_1 s = new Solution_1() ;
        return s.work(head) ;
    }
}

class Solution_1 {
    private String __V__ = "test_V" ;
    private String __error__ = "time limit" ;
    private String __desc__ = "把链表分成两段，进行归并操作" ;
    
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


class Solution_2 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public Solution_2() {}
    
    public ListNode work(ListNode head) {
        return sort(head) ;
    }
    
    private ListNode sort(ListNode head) {
        if (head==null || head.next==null) { return head ;}
        
        ListNode h1 = head ;
        ListNode h2 = head ;
        ListNode pre = head ;
        
        while (h2!=null && h2.next!=null) {
            pre = h1 ;
            h1 = h1.next ;
            h2 = h2.next.next ;
        }
        
        pre.next = null ; // 切断链表
        
        ListNode sortedList1 = sort(head) ;
        ListNode sortedList2 = sort(h1) ;
        
        ListNode resultList = merge(sortedList1, sortedList2) ;
        return resultList ;
        
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode h1 = list1 ;
        ListNode h2 = list2 ;
        
        ListNode resultList = new ListNode(-1) ;
        ListNode resultCur = resultList ;
        
        while(h1!=null || h2!=null) {
            int h1Value = (h1!=null) ? h1.val : 9999999 ;
            int h2Value = (h2!=null) ? h2.val : 9999999 ;
            
            if (h1Value < h2Value) {
                resultCur.next = h1 ;
                h1 = h1.next ;
            } else {
                resultCur.next = h2 ;
                h2 = h2.next ;
            }
            resultCur = resultCur.next ;
            resultCur.next = null ;
        }
        
        return resultList.next ;
    }
    
    // public ListNode merge(ListNode h1, ListNode h2){
    //     if(h1 == null){
    //         return h2;
    //     }
    //     if(h2 == null){
    //         return h1;
    //     }
        
    //     if(h1.val < h2.val){
    //         h1.next = merge(h1.next, h2);
    //         return h1;
    //     }
    //     else{
    //         h2.next = merge(h1, h2.next);
    //         return h2;
    //     }
        
    // }
    
    // public ListNode sortList(ListNode head) {
    //     //bottom case
    //     if(head == null){
    //         return head;
    //     }
    //     if(head.next == null){
    //         return head;
    //     }
        
    //     //p1 move 1 step every time, p2 move 2 step every time, pre record node before p1
    //     ListNode p1 = head;
    //     ListNode p2 = head;
    //     ListNode pre = head;
        
    //     while(p2 != null && p2.next != null){
    //         pre = p1;
    //         p1 = p1.next;
    //         p2 = p2.next.next;
    //     }
    //     //change pre next to null, make two sub list(head to pre, p1 to p2)
    //     pre.next = null;
        
    //     //handle those two sub list
    //     ListNode h1 = sortList(head);
    //     ListNode h2 = sortList(p1);
        
    //     return merge(h1, h2);
        
    // }
    
}
