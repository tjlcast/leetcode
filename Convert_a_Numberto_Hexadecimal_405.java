public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "负数为取反加一" ;
    
    public String toHex(int num) {
        long newNum = (long)num ;
        if (num == 0) return "0" ;
        if (num < 0) {
            long max = 4294967295L ;
            newNum = new Long(max + (long)num + 1) ;
            System.out.println("newNum: " + newNum) ;
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(newNum > 0) {
            int bit = (int)(newNum % 16) ;
            ans.append(getBit(bit)) ;
            
            newNum /= 16 ;
        }

        return ans.reverse().toString() ;
    }
    
    private String getBit(int bit) {
        switch(bit) {
            case 15:
                return "f";
            case 14:
                return "e" ;
            case 13:
                return "d" ;
            case 12:
                return "c" ;
            case 11:
                return "b" ;
            case 10:
                return "a" ;
            case 9:
                return "9" ;
            case 8:
                return "8" ;
            case 7:
                return "7" ;
            case 6:
                return "6" ; 
            case 5:
                return "5" ; 
            case 4:
                return "4" ; 
            case 3:
                return "3" ; 
            case 2:
                return "2" ; 
            case 1:
                return "1" ; 
            case 0:
                return "0" ; 
        }
        return "error" ;
    }

}
