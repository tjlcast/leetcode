class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        return Solution1().work(path)
        

class Solution1:
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def work(self, path):
        pathNodes = path.split('/')
        pathNodes = filter(lambda x: x!='.' and x!='', pathNodes)
        # print str(pathNodes)
        
        path = []
        for node in pathNodes:
            if node == '..':
                if len(path)!=0: 
                    path.pop(len(path)-1)
            else : 
                path.append(node)
        
        ans = '/'.join(path)
        
        return '/'+ans
