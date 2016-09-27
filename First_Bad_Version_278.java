/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "(end-begin)/2 + begin的求中值方式比(begin+end)/2方式快。注意二分查找的变种情况。" ;
    
    public int firstBadVersion(int n) {
        return findBadByTwo(n) ;
    }
    
    
    private int findBadByLinear(int n) {
        for(int i=1; i<=n; i++) {
            if (isBadVersion(i)==true) {
                return i ;
            }
        }
        return 0 ;
    }
    
    private int findBadByTwo(int n) {
        int begin = 1 ;
        int end = n ;
        while (begin<end) {
            int mid = (end-begin)/2 + begin; // 
            if (isBadVersion(mid)==true) {
                end = mid ;
            } else {
                begin = mid + 1 ;
            }
        }
        return begin ;
    }
}
