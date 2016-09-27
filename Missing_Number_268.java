public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int missingNumber(int[] nums) {
        int max = Integer.MIN_VALUE ;
        int count = 0 ;
        int len = nums.length ;
        
        for(int num : nums) {
            count += num;
            if (max < num){
                max = num ;
            }
        }
        
        if (len-1 == max) {
            return max+1 ;
        } 
        return (0 + max)*(len+1)/2 - count ;
    }
}
