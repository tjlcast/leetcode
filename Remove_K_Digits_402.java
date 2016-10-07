public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "重复k次，从高位依次删除第一个比下一个高的数。然后删除前面的0";
    
    public String removeKdigits(String num, int k) {
        StringBuilder ans = new StringBuilder(num) ;
        
        for(int j=0; j<k; j++) {
            for(int i=0; i<ans.length(); i++) {
                if (i<ans.length()-1 && ans.charAt(i)-ans.charAt(i+1)>0) {
                    ans.deleteCharAt(i) ;
                    break ;
                }
                
                if (i==ans.length()-1) {
                    ans.deleteCharAt(i) ;
                }
    
            }
        }
        
        while(ans.length()!=0 && ans.charAt(0)=='0') {
            ans.deleteCharAt(0) ;
        }
        if (ans.length()==0) {
            ans.append('0') ;
        }
        
        return ans.toString() ;
    }
}
