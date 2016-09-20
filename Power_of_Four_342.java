package Algorithms;

public class Power_of_Four_342 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 8 ;
		Solution_Power_of_Four_342 s = new Solution_Power_of_Four_342() ;
		boolean ans = s.isPowerOfFour(num) ;
		
		if(ans == true) {
			System.out.println("Result is: True") ;
		} else {
			System.out.println("Result is: False") ;
		}
	}

}

class Solution_Power_of_Four_342 {
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true ;
        
        boolean ans = false ;
        ans = check(num) ;
        return ans ;
    }
    
    boolean check(int num)
    {
    	if(num == 1) return true ;
    	
        if(num % 4 == 0) {
        	return check(num / 4);
        }

        return false ;
    }
}