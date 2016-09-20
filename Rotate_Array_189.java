package Algorithms;

public class Rotate_Array_189 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1} ;
		int k = 1 ;
		
		Solution_Rotate_Array_189 s =new Solution_Rotate_Array_189() ;
		s.rotate(nums, k);
		
		for(int i=0; i<nums.length; i++)
			System.out.println("result: " + nums[i]) ;
	}

}


class Solution_Rotate_Array_189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length ;
        if(len < k){
            k = k % len ;
        }
        
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len-1);
        reverse(nums, 0, len-1); 
        
    }
    
    public void reverse(int[] nums, int l, int r) {
    	System.out.println("L: " + l + "r: " + r) ;
    	while(l < r) {
    		int temp = nums[l] ;
    		nums[l] = nums[r] ;
    		nums[r] = temp ;
    		l++ ;
    		r-- ;
    	}
    }
}