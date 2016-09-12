class Solution(object):
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        mid = (0 + len(nums)) >> 1
        midNum = nums[mid]
        
        return midNum 
