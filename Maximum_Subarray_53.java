package Algorithms;

public class Maximum_Subarray_53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
		
		Solution_Maximum_Subarray_53 s = new Solution_Maximum_Subarray_53() ;
		int ans = s.maxSubArray(nums) ;
		
		System.out.println("ans: " + ans) ;
	}

}


class Solution_Maximum_Subarray_53 {
    public int maxSubArray(int[] nums) {
        int ans_max = -99999 ;
        
        int prefix_sum = -99999 ;
        for(int i=0; i<nums.length; i++) {
        	
        	ans_max = (ans_max < prefix_sum) ? (prefix_sum) : (ans_max) ;
        	if(prefix_sum < 0) {
        		prefix_sum = nums[i] ;
        	} else {
        		prefix_sum += nums[i] ;
        	}
        	
     
        	
        }
        
        
        return ans_max ;
    }
}