class Solution(object):
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def countSegments(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = filter(lambda x: x!='', s.split(' '))
        
        return len(l)
