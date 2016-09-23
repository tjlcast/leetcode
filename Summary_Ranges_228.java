class Solution(object):
    
    __author__ = "tangjialiang"
    __V__ = "success_V"
    
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        
        begin = 0 
        ansSet = []
        if len(nums)==0:
            return ansSet
        end = 1
        
        while end < len(nums):
            # print (str(nums[end]) ＋ " begin: " + str(begin) + " end: " + str(end))
            print "begin: " + str(begin) + " val: " + str(nums[begin])
            if nums[end-1]+1 != nums[end]:
                print "!=: " + str(nums[end])
                l = list(set([nums[begin], nums[end-1]]))
                l = sorted(l)
                s = '->'.join(map(str, l))
                ansSet.append(s)
                
                begin = end ;
            end+=1 
            # print nums[end]
        
        l = list(set([nums[begin], nums[end-1]]))
        l = sorted(l)
        s = '->'.join(map(str, l))
        ansSet.append(s)
        
        return ansSet
        
        
