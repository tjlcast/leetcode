public class Solution {
    public boolean containsDuplicate(int[] nums) {
        return new Solution1().work(nums) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public boolean work(int[] nums) {
        if (nums.length == 0) {
            return false ;
        }
        
        HashMap<Integer, Integer> recorder = new HashMap<Integer, Integer>() ;
        
        for(int num : nums) {
            if (recorder.get(num) == null) {
                recorder.put(num, 1) ;
            } else {
                return true ;
            }
        }
        return false ;
    }
}
