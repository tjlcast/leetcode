class Solution(object):
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num == 1:
            return True 
        if num < 0:
            return False 
        
        factors = [2, 3, 5]
        
        while num >= 1:
            if num in factors:
                return True 
            
            last_num = num  
            for factor in factors:
                if num % factor == 0:
                    num = num / factor 
                    break 
            if last_num == num:
                return False 
        return False
            
