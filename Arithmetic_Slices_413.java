public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    
    public int numberOfArithmeticSlices(int[] A) {
        return work(A) ;
    }
    
    public int work(int[] A) {
    	int total = 0 ;
        int lenOfA = A.length; 

        int[] B = new int[lenOfA] ;
        for(int i=1; i<lenOfA; i++) {
        	B[i] = A[i] - A[i-1] ;
        }

        int lastNum = Integer.MIN_VALUE ;
        int curLen = 1 ;
        for(int i=1; i<lenOfA; i++) {
        	if (lastNum != B[i]) {
        		if (curLen>=2) {
        			total += this.count(curLen+1) ;
        		}
        		curLen = 1 ;
        	} else {
        		curLen += 1 ;
        	}
        	lastNum = B[i] ;
        }
        
        if (curLen>=2) {
        	total += this.count(curLen+1) ;
        }
        return total ;
    }
    
    public int count(int maxLen) {
        int total = 0 ;
        int len = 3 ;
        
        while(len <= maxLen) {
            total += (maxLen - len + 1) ;
            len+=1 ;
        }
        return total ;
    }
}
