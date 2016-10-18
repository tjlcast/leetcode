public class Solution {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    String __tips__ = "逐个比较数组中所有的字符，使用两个int的bit位分别存储比较的两个字符的a－z出现情况" ;
    
    public int maxProduct(String[] words) {
        int ans = 0 ;
        
        for (int i=0; i<words.length; i++) {
            for(int j=i+1; j<words.length; j++) {
                String str1 = words[i] ;
                String str2 = words[j] ;
                
                if (isSame(str1, str2) == false) {
                    ans = (ans < (str1.length() * str2.length())) ? (str1.length() * str2.length()) : (ans) ;
                }
            }
        }
        
        return ans ;
    }
    
    private boolean isSame(String str1, String str2) {
        int flag1 = 0 ;
        for(int i=0; i<str1.length(); i++) {
            int pos = str1.charAt(i) - 'a' ;
            flag1 = flag1 | (1 << pos) ;
        }
        
        int flag2 = 0; 
        for(int i=0; i<str2.length(); i++) {
            int pos = str2.charAt(i) - 'a' ;
            flag2 = flag2 | (1 << pos) ;
        }
        return ((flag1 & flag2) == 0) ? (false) : (true) ;
    }
}
