package Algorithms;

public class Largest_Number_179 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3, 30, 34, 5, 9} ;
		Solution_Largest_Number_179 s = new Solution_Largest_Number_179() ;
		String ansStr = s.largestNumber(nums) ;
		
		System.out.println("get A str: " + ansStr) ;
	}

}


class Solution_temp {
    public String largestNumber(int[] nums) {
        Solution_Largest_Number_179 s = new Solution_Largest_Number_179() ;
		String ansStr = s.largestNumber(nums) ;
		
		//处理全为零的情况
		boolean is_zero = true ;
		for(int i=0; i<ansStr.length(); i++) {
		    if(ansStr.charAt(i) != '0') {
		        is_zero = false ;
		        break ;
		    }
		}
		if(is_zero == true) {
		    return new String("0") ;
		}
		
		return ansStr ;
    }
}

class Solution_Largest_Number_179 {
    public String largestNumber(int[] nums) {
        String[] nums_str = new String[nums.length] ;
        for(int i=0; i<nums.length; i++) {
        	nums_str[i] = (new Integer(nums[i])).toString();
        }
        
        for(int i=0; i<nums_str.length-1; i++) {
        	for(int j=i+1; j<nums_str.length; j++) {
        		if(cmp(nums_str[i], nums_str[j]) < 0) {
        			String temp = nums_str[i] ;
        			nums_str[i] = nums_str[j] ;
        			nums_str[j] = temp ;
        		}
        	}
        }
        
        String ansStr = new String("") ; 
        for(int i=0; i<nums_str.length; i++) {
        	ansStr = ansStr.concat(nums_str[i]) ;
        }
        
        return ansStr ;
    }
    
    private int cmp(String a, String b) {
    	String ab = a.concat(b) ;
    	String ba = b.concat(a) ;
    	
    	return (int) (Double.parseDouble(ab) - Double.parseDouble(ba)) ;
    }
}