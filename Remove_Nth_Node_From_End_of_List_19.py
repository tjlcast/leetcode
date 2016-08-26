# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    
    __author__ = "tangjialiang"
    __V__ = "success_V" 
    
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        queue = []
        self.push_to_queue(head, queue)
        queue.pop(len(queue)-n)
        return self.rebuild(queue)
        
        
    def push_to_queue(self, head, queue):
        cur = head 
        while cur != None: 
            queue.append(cur)
            cur = cur.next 
            
    
    def rebuild(self, queue): 
        head = ListNode(-1) 
        tail = head 
        while len(queue) != 0 :
            cur = queue.pop(0)
            tail.next = cur 
            tail = tail.next
        tail.next = None 
        return head.next 
            
        
        
