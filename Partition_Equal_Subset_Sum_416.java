public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public boolean canPartition(int[] nums) {
        return work(nums) ;
    }

    public boolean work(int[] nums) {
        // check edge 
        if (nums==null || nums.length==0) return true ;

        // preprocess
        int volumn = 0 ;
        for(int n : nums) volumn += n ;
        if (volumn % 2 != 0) return false ;
        volumn /= 2 ;

        // def dp 
        boolean[][] dp = new boolean[nums.length+1][volumn+1] ;
        // init dp 
        for(int i=0; i<dp.length; i++) dp[i][0] = true ;
        // transition dp 
        for(int i=1; i<dp.length; i++) {
            System.out.println("i-1: " + (i-1)) ;
            for(int j=nums[i-1]; j<=volumn; j++) { 
                dp[i][j] = (dp[i-1][j - nums[i-1]] || dp[i-1][j]) ;
            }
        }
        
        return dp[nums.length][volumn] ;
    }
}


