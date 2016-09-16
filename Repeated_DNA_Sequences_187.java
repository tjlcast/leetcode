public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        return new Solution2().work(s) ;
    }
}

class Solution1 {
    
    String __author__ = "tangjialiang" ;
    String __V__ = "wrong_ans_V" ;
    
    private HashMap<Integer, Integer> hasMap ;
    private ArrayList<String> ansSet ;
    
    private String getStrFromBits(int bit) {
        
        StringBuilder sb = new StringBuilder() ;
        int d = 0 ;
        while(bit>>d!=0) {

            if ((bit>>d & 1) == 1) {
                char word = (char)(d + (int)'A') ;
                sb.append(word) ;
            }
            d++ ;
        }
        System.out.println("str: " + sb.toString()) ;
        return sb.toString() ;
    }
    
    public List<String> work(String s) {
        if (s.length() < 11) {
            ansSet.add(new String("")) ;
            return ansSet ;
        }
        
        hasMap = new HashMap<Integer, Integer>() ;
        int sBegin = 0 ;
        int sEnd = 9 ;
        
        for(int k=0; k+sEnd<s.length(); k++) {
            int bit = 0 ;
            
            String subStr = s.substring(sBegin,sEnd+1) ;
            for(int strP=0; strP<subStr.length(); strP++) {
                char word = s.charAt(strP) ;
                int d = (char)(word - (int)'A') ;
                bit = bit | ( 1 << d ) ;
            }
            
            if (hasMap.get(bit)==null)  {
               hasMap.put(new Integer(bit), new Integer(1)) ;
            } else {
                hasMap.put(new Integer(bit), new Integer(hasMap.get(bit) + 1)) ;
            }
            
    
            for (Integer b: hasMap.keySet()) {
                if (hasMap.get(b) > 1) {
                    String str = getStrFromBits(b) ;
                    ansSet.add(str) ;
                }
            }
            
        }
        return (List)ansSet ;
    }
    
    
}


class Solution2 {
    String __author__ = "tangjialiang" ;
    String __V__ = "success_V" ;
    
    HashMap<String, Integer> strCount = new HashMap<String, Integer>() ;
    ArrayList<String> ansSet = new ArrayList<String>();
    
    public List<String> work(String s) {
        if (s.length() < 11) {
            //ansSet.add(new String("")) ;
            return ansSet ;
        }
        
        int sBegin = 0 ;
        int sEnd = 9 ;
        for(int k=0; k+sEnd<s.length(); k++) {
            String getStr = s.substring(sBegin+k, sEnd+k+1) ;
            
            if (strCount.get(getStr)==null) {
                strCount.put(getStr, new Integer(1)) ;
            } else {
                strCount.put(getStr, new Integer(strCount.get(getStr)+1) ) ;
            }
        }
        
        for(String key : strCount.keySet()) {
            //System.out.println("key: " + key + " time: " + strCount.get(key)) ;
            if (strCount.get(key) > 1) {
                ansSet.add(key) ;
            }
        }
        
        return (List)ansSet ;
    }
    
}
