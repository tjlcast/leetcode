public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "注意第一次就输入］，），｝的情况，以及stack出现的多余余留的情况" ;
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>() ;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i) ;
            if(isInputOp(c)) {
                stack.push(c) ;
            } else {
                if (stack.size() == 0) {return false ;}
                if (stack.pop() != getRightOp(c)) {
                    return false ;
                }
            }
        }
        if (stack.size()==0)return true ;
        return false ;
    }
    
    private boolean isInputOp(char op) {
        switch(op) {
            case '(':
                return true ;
            case '[':
                return true ;
            case '{':
                return true ;
            default:
                return false ;
        }
    }
    
    private char getRightOp(char op) {
        switch(op) {
            case ')':
                return '(' ;
            case ']':
                return '[' ;
            case '}':
                return '{' ;
            default:
                return '`' ;
        }
    }
}
