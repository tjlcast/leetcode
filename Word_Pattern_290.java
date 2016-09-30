public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "通过建立一对一映射，确定关系" ;
    
    public boolean wordPattern(String pattern, String str) {
        HashMap<String, String> wordDictChar = new HashMap<String, String>() ;
        HashMap<String, String> wordDictStr = new HashMap<String, String>() ;
        
        String[] words = str.split(" ") ;
        
        if (words.length != pattern.length()) return false ;
        
        for(int i=0; i<words.length; i++) {
            String c = pattern.substring(i, i+1) ;
            
            if (wordDictChar.get(c)==null) {
                wordDictChar.put(c, words[i]) ;
            } else {
                if (!wordDictChar.get(c).equals(words[i])) {
                    return false ;
                }
            }
            
            String s = words[i] ;
            if (wordDictStr.get(s)==null) {
                wordDictStr.put(s, c) ;
            } else {
                if (!c.equals(wordDictStr.get(s))) {
                    return false ;
                }
            }
        }
        
        return true ;
    }
}
