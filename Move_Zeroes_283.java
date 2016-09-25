public class Solution {
    public void moveZeroes(int[] nums) {
        
        private String __author__ = "tangjialiang" ;
        private String __V__ = "success_V" ;
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i] ;
            if (num==0) continue ;
            
            int j=i-1; 
            while(j>=0 && nums[j]==0) {
                j-- ;
            }
            
            j+=1 ;
            // System.out.println("i: " + nums[i] + " j: " + j) ;
            if (j>=0 && nums[j]==0) {
                // System.out.println("swap") ;
                int temp = nums[i] ;
                nums[i] = nums[j] ;
                nums[j] = temp ;
            }
        }
        
    }
}
