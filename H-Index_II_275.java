public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public int hIndex(int[] citations) {
        
        int[] appear = new int[citations.length] ;
        // Arrays.sort(citations) ; 
        
        for(int i=citations.length-1; i>=0; i--) {
            appear[i] = (citations.length - i) ;
        }
        
        for(int i=0; i<citations.length; i++) {
            if (citations[i] >= appear[i]) {
                return appear[i] ;
            }
        }
        return 0 ;
        
    }
}
