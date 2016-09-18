public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        return new Solution1().work(s, nums) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String tips = "两个指针, start end, end向后走,直到 sum 大于 s. 然后start向后, 直到sum 小于s. 同时更新 min值." ;
    
    public int work(int s, int[] nums) {
       int begin = 0 ;
       int end = 0 ;
       int curTotal = 0 ;
       int ans = Integer.MAX_VALUE ;
       int count = 0;
       
       while(end < nums.length) {
           curTotal+=nums[end++] ;
           count += 1;
           
           while (curTotal >= s) {
                ans = (count < ans) ? (count) : (ans) ; 
                curTotal-= nums[begin++] ;
                count -= 1 ;
           }
       }
       return (ans==Integer.MAX_VALUE) ? (0) : (ans) ;
    }
}
