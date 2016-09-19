public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        return new Solution1().work(nums, k, t) ;
    }
}

class Solution1 {
    
    
    
    public boolean work(int[] nums, int k, int t) {
        
         if(k<1 || t<0 || nums==null || nums.length<2) return false;  
        
        SortedSet<Long> kSet = new TreeSet<Long>() ;
        
        for (int i=0; i<nums.length; i++) {
            SortedSet<Long> tempSet =  kSet.subSet((long)nums[i]-t, (long)nums[i]+t+1);  
            if(!tempSet.isEmpty()) return true;  
            
            if (i >= k) {
                kSet.remove((long)nums[i-k]) ;
            }
            kSet.add((long)nums[i]) ;
        }
        
        return false ;
    }
}
