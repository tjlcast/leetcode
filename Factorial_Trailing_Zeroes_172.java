public class Solution {
    public int trailingZeroes(int n) {
        return new Solution1().work(n) ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "time_out_V" ;
    
    
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>() ;
    
    public int work(int n) {
        int total = 0 ;
        
        for(int i=1; i<=n; i++) {
            total += ((map.get(i)==null) ? (countS(i)) : (map.get(i))) ;
        }
        
        return total ;
    }
    
    private int countS(int s) {
        int num = s ;
        int count = 0 ;
        
        while(s%5 == 0) {
            count += 1 ;
            s = s / 5 ;
        }
        
        map.put(new Integer(num), new Integer(count)) ;

        return count ;
    }
    
}
