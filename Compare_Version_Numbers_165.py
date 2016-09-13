class Solution(object):
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        v1 = version1.split('.')
        v2 = version2.split('.')
        return self.compareV(v1, v2)
        
    def compareV(self, v1, v2):
        diffLen = len(v1) - len(v2)
        
        if (diffLen > 0) :
            v2.extend([0 for x in range(diffLen)])
        
        if (diffLen < 0) :
            v1.extend([0 for x in range(diffLen*(-1))])
        
        for pos in range(0, len(v1)):
            intV1 = int(v1[pos])
            intV2 = int(v2[pos])
            if intV1 > intV2:
                return 1
            elif intV1 < intV2:
                return -1
        
        return 0 
            
