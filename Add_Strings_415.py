class Solution(object):
    
    __author__ = 'tangjialiang'
    __V__ = "success_V"
    
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        num1 = num1[::-1]
        num2 = num2[::-1]
        
        len1 = len(num1) 
        len2 = len(num2) 
        max_len = max(len1, len2)
        
        l = []
        forward = 0 
        
        for pos in range(0, max_len):
            a = 0 
            b = 0 
            try:
                a = int(num1[pos])
            except Exception as e:
                pass 
            try:
                b = int(num2[pos])
            except Exception as e:
                pass 
            temp_sum = a + b + forward
            l.append(str(temp_sum % 10))
            forward = temp_sum / 10 
        
        if forward!=0:
            l.append(str(forward))
        
        l.reverse()
        return ''.join(l)
            
