public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success" ;
    
    public int arrangeCoins(int n) {
        return work(n) ;
    }
    
    public int work(int n) {
        return (int)(Math.sqrt(2*(long)n + 0.25) - 0.5);
    }
}
