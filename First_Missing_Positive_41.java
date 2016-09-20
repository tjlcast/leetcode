package Algorithms;

import java.util.Collection;
import java.util.Collections;

public class First_Missing_Positive_41 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 3, 6} ;
		Solution_First_Missing_Positive_41 s = new Solution_First_Missing_Positive_41() ;
		int result = s.firstMissingPositive(nums) ;
		
		System.out.println("result: " + result) ;
	}

}


class Solution_First_Missing_Positive_41 {
    public int firstMissingPositive(int[] nums) {
    	int ans = 1 ;
    	sort(nums);
    	
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i] == ans) {
    			ans++ ;
    		}
    	}
    	
        return ans ;
    }
    
    private void sort(int[] nums) {
    	for(int i=0; i<nums.length-1; i++) {
    		for(int j=i+1; j<nums.length; j++) {
    			if(nums[i] > nums[j]) {
    				int temp = nums[i] ;
        			nums[i] = nums[j] ;
        			nums[j] = temp ;
    			}
    		}
    	}
    }
    
}