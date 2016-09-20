package Algorithms;

public class Add_Binary_67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1110" ;
		String b = "10" ;
		
		Solution_Add_Binary_67 s = new Solution_Add_Binary_67() ;
		s.addBinary(a, b) ;
		
		
	}

}


class Solution_Add_Binary_67 {
    public String addBinary(String a, String b) {
    	StringBuffer tempA = new StringBuffer(a) ;
    	StringBuffer tempB = new StringBuffer(b) ;
    	a = tempA.reverse().toString() ;
    	b = tempB.reverse().toString() ;
    	
        if(a.length() < b.length()){ 
        	String temp = a ;
        	a = b ;
        	b = temp ;
        }
        int[] sum = new int[a.length() + 1] ;
        for(int i=0; i<sum.length; i++) {
        	sum[0] = 0 ;
        }
        
        for(int i=0; i<a.length(); i++) {
        	char word_a = a.charAt(i) ;
        	char word_b ;
        	if(i < b.length()) {
        		word_b = b.charAt(i) ;
        	} else {
        		word_b = '0' ;
        	}
        	
        	sum[i] = (word_a-'0') + (word_b-'0') ;
        }
        
        StringBuffer ansBuffer = new StringBuffer(sum.length) ; 
        for(int i=0; i<sum.length; i++) {
        	if(sum[i] > 1) {
        		sum[i+1] += sum[i] / 2 ;
        		sum[i] = sum[i] % 2 ;
        	}
        	char word = (char) ('0' + sum[i]) ;
        	ansBuffer.append(word) ;
        }
        if(ansBuffer.charAt(ansBuffer.length()-1) == '0') ansBuffer.deleteCharAt(ansBuffer.length()-1) ;
        //System.out.println("ans:" + ansBuffer.reverse().toString()) ;
        return ansBuffer.reverse().toString() ;
    }
}