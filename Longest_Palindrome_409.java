public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "出现次数为偶数的肯定在回文中，出现奇次的数肯定在回文中以减一的形式出现(并且肯定可以选取一个奇数次的数放在回文的中间故最后需要加一)" ;
    
    public int longestPalindrome(String s) {
        HashMap<String, Integer> charTime = new HashMap<String, Integer>() ;
        
        // build times 
        for(int i=0; i<s.length(); i++) {
            String c = s.substring(i, i+1) ;
            if (charTime.containsKey(c)) {
                charTime.put(c, charTime.get(c)+1) ;
            } else {
                charTime.put(c, 1) ;
            }
        }
        
        // judge
        boolean hasOdd = false ;
        int total = 0 ;
        for(String key: charTime.keySet()) {
            
            if (charTime.get(key)%2 == 0) {
                total += charTime.get(key) ;
            } else {
                total += charTime.get(key) - 1;
                hasOdd = true ;
            }
        }
        
        if (hasOdd) total+=1 ;
        return total ;
    }
}
