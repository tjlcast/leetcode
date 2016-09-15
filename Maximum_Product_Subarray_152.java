public class Solution {
    public int maxProduct(int[] nums) {
        return new Solution1().work(nums) ;
    }
}

class Solution1 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    
    public int work(int[] nums) {
        if (nums==null || nums.length == 0) return 0 ;
        if (nums.length < 2) return nums[0] ;
        
        int global = nums[0] ;
        int max = nums[0];
        int min = nums[0] ;
        
        for(int i=1; i<nums.length; i++) {
            int num = nums[i] ;
            int a = max * num ;
            int b = min * num ;
            
            max = Math.max(num, Math.max(a, b)) ;
            min = Math.min(num, Math.min(a, b)) ;
            
            global = Math.max(max, global) ;
        }
        
        return global ;
    }
}
