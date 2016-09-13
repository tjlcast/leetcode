class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        return Solution1().work(n-1)
        

class Solution1(object) :
    
    __author__ = "tangjialiang" 
    __V__ = "success_V"
    
    word = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    
    def work(self, n):
        ansStr = ''
        if n < 0:
            return ansStr 
        
        if n==0:
            return 'A'
        
        while n>=0 :
            # print 'n: ' + str(n)
            pos = n % 26
            n = n / 26 
            n -= 1
            ansStr = Solution1.word[pos] + ansStr 
        
        return ansStr
