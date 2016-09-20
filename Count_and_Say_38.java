package Algorithms;

public class Count_and_Say_38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_Count_and_Say_38 s= new Solution_Count_and_Say_38() ;
		String str = s.countAndSay(3) ;
		System.out.println("str: " + str) ;
	}

}


class Solution_Count_and_Say_38 {
    public String countAndSay(int n) {
    	String str = "1" ;
    	if(n == 1) return str ;
    	
        for(int i=1; i<n; i++) {
        	str = generateNext(str) ;
        }
        return str ;
    }
    /*
     * 1->11
     * 11->21
     * 21->1211
     * */
    public String generateNext(String str) {
    	StringBuilder ans = new StringBuilder() ;
    	
    	StringBuilder sb = new StringBuilder(str) ;
    	int l = 0 , r = 0 ;
    	while(r < sb.length()) {
    		while(r < sb.length() && sb.charAt(r) == sb.charAt(l)) {
    			r++ ;
    		}
    		
    		String num = (r-l) + "" ;
    		String word = sb.charAt(l)+"" ;
    		l = r ;
    		ans.append(num + word) ;
    		
    	}
    	return ans.toString() ;
    }
}