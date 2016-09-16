public class Solution {
    public int countPrimes(int n) {
        return new Solution2().work(n) ;
    }
}


public class Solution2 {  
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    String tips = "素数不能被比它小的整数整除, 建一个boolean 数组, 从2开始, 把其倍数小于N的都删掉." ;
    
    public int work(int n) {  
         boolean[] a = new boolean[n];  
         
         for(int i=2; i*i<n; i++) {  
            if(!a[i]) {  
                for(int j=i; i*j<n; j++) {  
                    a[i*j] = true;  
                }  
            }  
         }  
         int c=0;  
       
         for(int i=2; i<n; i++) {  
             if(a[i] == false) ++c;  
         }  
         return c;  
    }  
}  

class Solution1 {
    public int work(int n) {
        int total = 0 ;
        for(int i=1; i<n; i++) {
            if (isPrime(i)) {
                //System.out.println("I: " + i);
                total++ ;
            }
        } 
        return total ;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) {return false ;}
        
        for(int i=2; i<=n/2; i++) {
            if (n%i == 0) {
                return false ;
            }
        }
        return true ;
    }
}
