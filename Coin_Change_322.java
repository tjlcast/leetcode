public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "dp： 注意不可到达状态" ;
    
    
    public int coinChange(int[] coins, int amount) {
       if (amount == 0) return 0; 
       
       int[] dp = new int[amount+1] ;
       Arrays.sort(coins) ;
       
       // initial 
       for(int i=0; i<dp.length; i++) {
           if (Arrays.binarySearch(coins, i) >= 0) {
               dp[i] = 1 ;
           } else {
               dp[i] = -1 ;
           }
       }
       
       // work 
       for(int i=1; i<=amount; i++) {
           if (dp[i] != -1) continue ;
           int curVal = Integer.MAX_VALUE ;
           for(int j=0; j<coins.length; j++) {
               int val = coins[j] ;
               if (i - val >= 0 && dp[i-val] != -1) {
                   curVal = (curVal > dp[i - val]+1) ? (dp[i - val]+1) : (curVal) ;
               }
           }
           dp[i] = (curVal==Integer.MAX_VALUE) ? (-1) : (curVal) ;
       } 
       
       return dp[amount] ;
        
    }
}
