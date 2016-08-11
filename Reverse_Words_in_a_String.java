public class Solution {
    private String __author__ = 'tangjialiang' ;
    private String __V__ = 'code_V' ;
    
    
    public String reverseWords(String s) {
        
    }
    
    private String work(String s) {
        if (s.length == 0) {return s; }
        char[] words = s.toArray()
        
        swap(words, 0, words.length-1) ;
        int head = 0;
        for(int tail=0; tail<words.length; tail++) {
            if (words[tail] == ' ') {
                swap(words, begin, tail-1) ;
                head = tail + 1 ;
            }
        }
    }
    
    private void swap(char[] words, int begin, int end) {
        
        while(begin < end) {
            char tempWord = words[begin] ;
            words[begin] = words[end] ;
            words[end] = tempWord ;
        }
    }
}
