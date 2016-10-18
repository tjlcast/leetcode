class Solution_01 {
    public int bulbSwitch(int n) {
        
        int[] bulbs = new int[n] ;
        
        for(int i=1; i<=n; i++) {
            next(i, n, bulbs) ;
            
            // for(int bulb : bulbs) {
            //     System.out.print(bulb + " ") ;
            // }
            // System.out.println("") ;
        }
        
        int ans = 0 ;
        for(int bulb : bulbs) {
            // System.out.println("bulb: "  + bulb) ;
            if (bulb == 1) ans += 1 ;
        }
        
        return ans ;
    }
    
    public void next(int step, int n, int[] bulbs) {
        int len = bulbs.length ;
        if (step == 1) {
            for(int i=0; i<bulbs.length; i++) bulbs[i] = 1 ;
            return ;
        }
        
         if (step == 2) {
            for(int i=step-1; i<bulbs.length; i=(i+step)) bulbs[i] =  0 ;
            return ;
        }
        
        for(int pos=step-1; pos<bulbs.length; pos=(pos+step)) {
            bulbs[pos] = (bulbs[pos] == 1) ? (0) : (1) ;
        }
        
        return ;
    }
    
}


public class Solution {
    public int bulbSwitch(int n) {
        int result = 0;
        for (int i = 1; i * i <= n; ++i, ++result)
            ;
        return result;
    }
}
