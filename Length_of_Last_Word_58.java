package Algorithms;

public class Length_of_Last_Word_58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "" ;
		Solution_Length_of_Last_Word_58 s = new Solution_Length_of_Last_Word_58() ;
		int len = s.lengthOfLastWord(str) ;
		
		System.out.println("len: " + len) ;
	}

}


class Solution_Length_of_Last_Word_58 {
    public int lengthOfLastWord(String s) {
        int len = 0 ;
        
        if(s.length() == 0) {
            return len ;
        }
        
        int head = 0 ;
        int tail = s.length()-1 ;
        while(head<s.length() && s.charAt(head) == ' ') {
        	head++ ;
        }
        while(tail >= 0 && s.charAt(tail) == ' ') {
        	tail-- ;
        }
        
        if(head > tail){
            return len ;
        }
        
        int l = head ;
        int r = head ;
        
        while(r <= tail) {
        	if(s.charAt(r) == ' ') {
        		l = r+1;
        	}
        	r++ ;
        }
        
        System.out.println("r: "+r+"l: "+l) ;
        
        len = r - l;
        
        return len ;
    }
}