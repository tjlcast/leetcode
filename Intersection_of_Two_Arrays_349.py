class Solution(object):
    
    __author__ = 'tangjialiang'
    __V__ = 'success_V'
    
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        
        ans = []
        
        nums1 = list(set(nums1))
        nums2 = list(set(nums2))
        
        for num in nums1:
            if num in nums2:
                ans.append(num) 
            
        return ans 
        
