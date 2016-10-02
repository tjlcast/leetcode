public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "当前个数的Nim game是否能赢取决于对手下一次取是否能赢（相当于自己是否能输）" ;
    
    private int[] dp ;
    
    public boolean canWinNim(int n) {
        return judgeByMath(n) ;
    }
    
    private void initalDp(int n) {
        dp = new int[n+1] ;
        for(int i=0; i<dp.length; i++) dp[i] = -1 ;
    }
    
    private boolean judge(int n) {
        if (n<=3) return true ;
        if (n == 4) return false ;
        
        if (dp[n] != -1) return dp[n]==1 ;
        
        boolean ans = false ;
        for(int i=1; i<=3; i++) {
            if (!judge(n-i)) {
                ans = true ;break ;
            }
        }
        
        dp[n] = (ans) ? (1) : (0) ;
        // System.out.println("n: " + n + " : " + dp[n]) ;
        return dp[n] == 1 ;
    }
    
    private boolean judgeByMath(int n) {
        return (n%4)!=0 ;
    }
}
