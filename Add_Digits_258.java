public class Solution {
    
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int addDigits(int num) {
        int i = num ;
        while(i/10 != 0) {
            i = getBitSum(i) ;
        }
        return i ;
    }
    
    private int getBitSum(int num) {
        if (num == 0) return 0 ;
        return (num%10) + getBitSum(num/10) ;
    }
}
