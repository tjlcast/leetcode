package Algorithms;

import java.util.ArrayList;

public class Plus_One_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Solution_Plus_One_66 s= new Solution_Plus_One_66() ;
		 int[] digits = {1, 0} ;
		 int[] ans = s.plusOne(digits) ;
		 
	     
		 for(int i=0; i<ans.length; i++) {
			 System.out.print(" "+ans[i]) ;
		 }
		 System.out.println("") ;
	}

}

class Solution_Plus_One_66 {
	
	private ArrayList<Integer> ansData ;

    public int[] plusOne(int[] digits) {
    	reverse(digits) ;
        
    	ansData = new ArrayList<>(digits.length+1) ;
    	for(int i=0; i<digits.length; i++) {
    		ansData.add(new Integer(digits[i])); 
    	}
    	ansData.add(new Integer(0)) ;
    	
    	
        add(digits, 0, 1) ;
        for(int i=1; i<digits.length; i++) {
        	add(digits, i, 0) ;
        }
        while(ansData.get(ansData.size()-1) == 0) {
        	ansData.remove(ansData.size()-1) ;
        }
        
        int[] temp = new int[ansData.size()] ;
        for(int i=0; i<ansData.size(); i++) {
        	temp[i] = ansData.get(i) ;
        }
        reverse(temp);

        return temp ;
    }
    
    private void add(int[] digits, int pos, int plus) {
    	int sum = ansData.get(pos) + plus  ;
    	ansData.set(pos, sum % 10) ;
    	if(sum > 9) {
    		add(digits, pos+1, sum/10) ;
    	}
    }
    
    
    private void reverse(int[] digits) {
    	if(digits == null) return ;
    	
    	int l = 0 ;
    	int r = digits.length-1 ;
    	
    	while(l < r) {
    		int temp = digits[l] ;
    		digits[l] = digits[r] ;
    		digits[r] = temp ;
    		l++ ;
    		r-- ;
    	}
    }
}