public class Solution {
    
    private String __author__ = "network" ;
    private String __V__ = "success_V" ;
    private String __s__ = "http://www.cnblogs.com/jdneo/p/5228004.html" ;
    
    public int maxProfit(int[] prices) {
        
        if (prices.length <= 1) return 0 ;
        
        int[] s0 = new int[prices.length] ;
        int[] s1 = new int[prices.length] ;
        int[] s2 = new int[prices.length] ;
        
        s1[0] = -1*prices[0] ;
        s0[0] = 0 ;
        s2[0] = Integer.MIN_VALUE ;
        
        for(int i=1; i<prices.length; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]) ;
            s1[i] = Math.max(s1[i-1], s0[i-1]-prices[i]) ;
            s2[i] = s1[i-1] + prices[i] ;
        }
        
        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);

    }
}
