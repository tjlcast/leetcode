public class Solution {
    public boolean isIsomorphic(String s, String t) {
        return new Solution2().work(s, t) ;
    }
}

class MyPair {
    public String s ;
    public String t ;
    
    public MyPair(String s, String t) {
        this.s = s ;
        this.t = t ;
    }
    
    public int hashCode(){
        return 0 ;
    }
    
    public boolean equals(MyPair p) {
        System.out.println("com") ;
        if (this.s.equals(p.s)==true || this.t.equals(p.t)==true) {
            return true ;
        }
        return false ;
    }
    
    @Override
    public String toString() {
        return this.s + " - " + this.t ;
    }
}

class Solution1 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "wrong_ans_V" ;
    
    Set<MyPair> mySet = new HashSet<MyPair>() ;
    
    public boolean work(String s, String t) {
        return toR(s, t) ;
    }
    
    private boolean toR(String s, String t) {
        for(int i=0; i<s.length(); i++) {
            String wordS = s.substring(i, i+1) ;
            String wordT = t.substring(i, i+1) ;
            MyPair p = new MyPair(wordS, wordT) ;
            
            if(mySet.add(p) == false) {
                return false ;
            } 
        }
        
        System.out.println("hashset: " + mySet)  ;
        return true ;
    }
}

class Solution2 {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    HashMap<String, String> wordFromS = new HashMap<String, String>() ;
    HashMap<String, String> wordFromT = new HashMap<String, String>() ; 
    
    public boolean work(String s, String t) {
        for (int pos=0; pos<s.length(); pos++) {
            String wordS = s.substring(pos, pos+1) ;
            String wordT = t.substring(pos, pos+1) ;
            
            if(wordFromS.get(wordS)==null) {
                wordFromS.put(wordS, wordT) ;
            } else {
                if (wordFromS.get(wordS).equals(wordT) == false) {
                    return false ;
                }
            }
            
            if(wordFromT.get(wordT)==null) {
                wordFromT.put(wordT, wordS) ;
            } else {
                if (wordFromT.get(wordT).equals(wordS) == false) {
                    return false ;
                }
            }
        }
        return true ;
    }
}
