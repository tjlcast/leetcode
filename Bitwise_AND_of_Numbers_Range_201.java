public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int rangeBitwiseAnd(int m, int n) {
        int bits = 0 ;
        
        while(m != n) {
            m = m >> 1;
            n = n >> 1;
            
            bits++ ;
        }
        
        return m<<bits ;
    }
}
