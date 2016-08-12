public class Solution {
    private String __author__ = "tangjialiang" ;
    private String __V__ = "code_V" ;
    
    
    public String reverseWords(String s) {
        return work(s) ;
    }
    
    private String work(String s) {
        String[] words = s.split(" ") ;
        swapString(words) ;
        return join(words, " ") ;
    }
    
    private void swapString(String[] words) {
        System.out.println("len : " + words.length) ;
        for (int i=0; i<words.length; i++) {
            System.out.println(i +" : "+ words[i]) ;
        }
        if (words.length == 0) {return ;}
        
        int begin = 0 ;
        int end = words.length-1 ;
        while(begin < end) {
            String tempWord = words[begin++] ;
            words[begin] = words[end--] ;
            words[end] = tempWord ;
        }
        return ;
    }
    
    private String join(String[] words, String op) {
        if (words.length == 0) {return "" ;}
        StringBuffer sb = new StringBuffer() ;
        
        for (int i=0; i<words.length; i++) {
            String word = "";
            if (i == 0) {word = words[i] ;} 
            else {word = op+word ;}
            sb.append(word) ;
        }
        return sb.toString() ;
    }
    
}
