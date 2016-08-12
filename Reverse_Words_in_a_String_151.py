import re

class Solution(object):
    
    def __init__(self):
        self.__author__ = 'tangjialiang'
        self.__V__ = 'success_V'
    
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        s = s.strip()
        s = re.sub(r' +', ' ', s)
        return self.work(s)
        
    def work(self, s): 
        words = s.split(' ')
        words.reverse() 
        return ' '.join(words)
