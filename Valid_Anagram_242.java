import java.util.* ;

public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public boolean isAnagram(String s, String t) {
        Hashtable<Character, Integer> sSet = new Hashtable<Character, Integer>() ;
        Hashtable<Character, Integer> tSet = new Hashtable<Character, Integer>() ;
        
        for(int i=0; i<s.length(); i++) {
            if (sSet.get(s.charAt(i))!=null) {
                sSet.put(s.charAt(i), sSet.get(s.charAt(i))+1) ;
            } else {
                 sSet.put(s.charAt(i), 1) ;
            }
        }
        for(int i=0; i<t.length(); i++) {
            if (tSet.get(t.charAt(i))!=null) {
                tSet.put(t.charAt(i), tSet.get(t.charAt(i))+1) ;
            } else {
                 tSet.put(t.charAt(i), 1) ;
            }
        }
        
        if (sSet.keySet().equals(tSet.keySet())) {
            for(char c : sSet.keySet()) {
                if (sSet.get(c).equals(tSet.get(c)) == false) {
                    return false ;
                }
            }
            return true ;
        }
        
        return false ;
    }
}
