public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "通过一个hashMap纪录之前数出现的情况" ;
    
    public int lengthOfLIS(int[] nums) {
        int ans = 0 ;
        
        HashMap<Integer, Integer> dp = new HashMap<Integer, Integer>() ;
        
        for (int i=0; i<nums.length; i++) {
            int num = nums[i] ;
            
            int lastTime = 0 ;
            for(int lastNum : dp.keySet()) {
                if (lastNum < num) {
                    lastTime = (dp.get(lastNum) > lastTime) ? (dp.get(lastNum)) : (lastTime)  ;
                }
            }
            
            dp.put(num, lastTime+1) ;
            if (lastTime+1 > ans) ans = lastTime+1 ;
        }
        
        return ans ;
    }
}
