class Solution(object):
    
    __author__ = "tangjialiang" 
    __V__ = "success_V"
    
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        
        ans = []
        is_visit = [False for num in nums1]
        
        for i in range(len(nums2)):
            print 'i' + str(i)
            num = nums2[i]
            for j in range(len(nums1)):
                if num == nums1[j] and is_visit[j]==False:
                    ans.append(num)
                    is_visit[j] = True 
                    break 
        return ans 
