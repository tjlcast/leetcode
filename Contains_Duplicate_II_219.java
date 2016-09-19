public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        return new Solution1().work(nums, k) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public boolean work(int[] nums, int k) {
        if (nums.length == 0) {
            return false ;
        }
        
        HashMap<Integer, Integer> recorder = new HashMap<Integer, Integer>() ;
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i] ;
            if (recorder.get(num) == null) {
                recorder.put(num, i) ;
            } else {
                int pos = recorder.get(num) ;
                if (i - pos <= k) {
                    return true ;
                }
                recorder.put(num, i) ;
            }
        }
        return false ;
    }
}
