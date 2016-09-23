# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param {TreeNode} root
    # @return {string[]}
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def __init__(self):
        self.stack = [] 
        self.ans = [] 
    
    def binaryTreePaths(self, root):
        self.dfs(root) 
        return self.ans 
    
    def dfs(self, root):
        if root == None:
            return 
        
        self.stack.append(str(root.val))
        if root.left==None and root.right==None:
            s = '->'.join(self.stack)
            self.ans.append(s)
        self.dfs(root.left)
        self.dfs(root.right) 
        self.stack.pop() 
        
