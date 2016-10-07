package Algorithms;

public class Next_Permutation_31 {
	
	private String __author__ = "tangjialiang" ;
	private String __V__ = "success_V" ;
	private String __tips__ = "因为一个数的地位变化是最小的（也是最先的），从左向右找到第一个递增的数，之后这个数与它之后的数（都比该数大）进行交换" ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//{6, 5, 4, 8, 7, 5, 1}
		int[] nums = {1 ,2  ,3} ;
//		Solution_Next_Permutation_31.sort(nums, 0, 4) ;
		Solution_Mine.nextPermutation(nums);
		for(int num: nums) {
			System.out.println("num: " + num) ;
		}
	}

}

//首先肯定从后面开始看，1和5调换了没有用。
//
//7、5和1调换了也没有效果，因此而发现了8、7、5、1是递减的。
//
//如果想要找到下一个排列，找到递增的位置是关键。
//
//因为在这里才可以使其增长得更大。
//
//于是找到了4，显而易见4过了是5而不是8或者7更不是1。
//
//因此就需要找出比4大但在这些大数里面最小的值，并将其两者调换。
//
//那么整个排列就成了：6 5 5 8 7 4 1
//
//然而最后一步将后面的8 7 4 1做一个递增。

class Solution_Mine {
    public static void nextPermutation(int[] nums) {
    	for(int i=nums.length-2; i>=0; i--) {
    		int minPos = -1 ;
    		for(int j=i+1; j<nums.length; j++) {
    			if(nums[j] > nums[i]) {
    				if(minPos == -1) {
    					minPos = j ;
    				} else {
    					if(nums[j] < nums[minPos]) {
    						minPos = j ;
    					}
    				}
    			}
    		}
    		
    		if(minPos != -1) {
    			int temp = nums[i] ;
    			nums[i] = nums[minPos] ;
    			nums[minPos] = temp ;
    			sort(nums, i+1, nums.length-1) ;
    			
    			return  ;
    		}
    	}
    	
    	sort(nums, 0, nums.length-1) ;
    	
    }
    
    
    static void sort(int[]nums, int begin, int end) {
    	System.out.println("Enter begin: " + begin + " end: " + end);
    	for(int i=begin; i<end; i++) {
    		for(int j=i+1; j<=end; j++) {
    			if(nums[i] > nums[j]) {
    				int temp = nums[i] ;
    				nums[i] = nums[j] ;
    				nums[j] = temp ;
    			}
    		}
    	}
    }
}



