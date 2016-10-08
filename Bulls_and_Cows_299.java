public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "分两次扫描，第一次扫描相同情况，第二次扫描不同情况" ;
    
    private int[] isUse ;
    
    public String getHint(String secret, String guess) {
        isUse = new int[secret.length()] ;
        int bulls = 0 ;
        int cows = 0 ;
        
        for (int i=0; i<guess.length(); i++) {
            String curS = guess.substring(i, i+1) ;
            
            if (curS.equals(secret.substring(i, i+1))) {
                isUse[i] = 1 ;
                bulls += 1 ;
            } 
        }
        
        for(int i=0; i<guess.length(); i++) {
            String curS = guess.substring(i, i+1) ;
            
            if (!curS.equals(secret.substring(i, i+1))) {
                int res = findPosOther(i, secret, curS) ;
                if (res != -1) {
                    isUse[res] = 1 ;
                    cows += 1 ;
                }
            }
        }
        
        return bulls + "A" + cows + "B" ;
    }
    
    private int findPosOther(int curPos, String secret, String word) {
        
        for(int i=0; i<secret.length(); i++) {
            if (i != curPos && isUse[i]==0 && word.equals(secret.substring(i, i+1))) {
                return i ;
            }
        }
        
        return -1 ;
    }
}
