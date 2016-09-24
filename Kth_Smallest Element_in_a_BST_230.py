# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    __tips__ = "使用先序遍历的非递归"
    
    def __init__(self):
        self.kth_num = None
    
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        return self.dfs(root, k)
    
    # return the number of the node of cur tree
    def dfs(self, root, k):
        queue = []
        i = 0
        
        while root != None:
            queue.append(root)
            root = root.left
        
        while len(queue)!=0:
            top = queue.pop()
            # print top.val
            i += 1
            if i == k:
                return top.val
            root = top.right
            while root != None:
                queue.append(root)
                root = root.left
                
