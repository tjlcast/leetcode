public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return new Solution1().work(s, wordDict) ;
    }
}


class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public boolean work(String s, Set<String> wordDict) {
        if (wordDict.isEmpty()) return false ;
        if (s.length()==0) return true ;
        
        int[] dp = new int[s.length() + 1] ;
        dp[0] = 1 ;
        
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (dp[j]==1 && (wordDict.contains(s.substring(j,i))==true)) {
                    dp[i] = 1 ;
                    break ;
                }
            }
        }
        
        if(dp[s.length()]==1) {  
            return true;  
        } else {  
            return false;  
        }  
    }
}
