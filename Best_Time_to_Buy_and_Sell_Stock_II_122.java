public class Solution {
    public int maxProfit(int[] prices) {
        return new Solution2().maxProfit(prices) ;
    }
}

class Solution1 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "wrong_V" ;
    
    public int maxProfit(int[] prices) {
        boolean[] flag = new boolean[prices.length] ;
        int ans = 0 ;
        for(int i=0; i<prices.length; i++) {
            int curPrice = prices[i] ;
            int maxProfit = findMax(prices, flag, i) ;
            
            if (maxProfit!=-1) {
                int curProfit = maxProfit - curPrice ;
                ans = (curProfit > ans) ? (curProfit) : (ans) ;
            }
        }
        
        return ans ;
    }
    
    private int findMax(int[] prices, boolean[] flag, int pos) {
        int maxPrice = prices[pos] ;
        
        int maxPos = -1 ;
        for(int i=pos+1; i<prices.length; i++) {
            if (flag[i]==false && maxPrice<=prices[i]) {
                maxPrice = prices[i] ;
                maxPos = i ;
            }
        }
        
        if (maxPos != -1) {
            flag[maxPos] = true ;
            return maxPrice ;
        }
        return -1 ;
    }
}

class Solution2 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    String __tip__ = "可以把股票每天的价格视为连续的图。因为可以多次买入卖出，故连续图斜率为正的线段之和为最大价格" ;
    
    public int maxProfit(int[] prices) {
        
        int profit = 0 ;
    
        for(int i=0; i<prices.length-1; i++) {
            int priceA = prices[i] ;
            int priceB = prices[i+1] ;
            
            System.out.println("A:"+ priceA +"B:" + priceB) ;
            
            if (priceB > priceA)profit += (priceB - priceA) ;
        }
        
        return profit ;
    }
}
