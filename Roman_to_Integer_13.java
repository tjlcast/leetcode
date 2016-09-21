public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "字符串从后向前时，如果当前的字符数字比上一个字符数字小，则从total从减去当前字符数字。";
    
    public int romanToInt(String s) {
        int curNum = -1 ;
        int lastNum = Integer.MIN_VALUE ;
        int total = 0 ;
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i) ;
            curNum = toNumber(c) ;
            // System.out.println("cur: " + curNum) ;
            if (curNum >= lastNum) {
                total += curNum ;
            } else {
                total -= curNum ;
            }
            lastNum = curNum ;
        }
        return total ;
    }
    
    int toNumber(char ch) {  
        switch (ch) {  
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }  
        return 0;  
    }  
}
