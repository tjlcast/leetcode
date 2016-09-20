package Algorithms;

public class Search_Insert_Position_35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,3,5,6} ;
		int target = 0 ;
		
		int pos = Solution_Search_Insert_Position_35.searchInsert(nums, target) ;
		System.out.println("pos: " + pos) ;
	}

}

class Solution_Search_Insert_Position_35 {
	
    public static int searchInsert(int[] nums, int target) {
        int pos = find(nums, 0, nums.length-1, target) ;
        return pos ;
    }
    
    public static int find(int[] nums, int l, int r, int target) {
    	while(l <= r) {
    		int mid = (l + r) / 2 ;
    		if(nums[mid] < target) {
    			l = mid + 1 ;
    		} else {
    			r = mid - 1 ;
    		}
    	}
    	
    	if(r < 0) return 0 ;
    	return l ;
    }
}