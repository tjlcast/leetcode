package Algorithms;

public class Search_for_a_Range_34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1} ;
		int target = 0 ;
		int[] ans = Solution_Search_for_a_Range_34.searchRange(nums, target) ;
		System.out.println("ans[0]:" + ans[0] +" ans[1]:" + ans[1]) ;
	}

}


class Solution_Search_for_a_Range_34 {
	public static int[] searchRange(int[] nums, int target) {
		int[] ans = {-1, -1} ;
		
		int L = findL(nums, 0, nums.length-1, target) ;
		int R = findR(nums, 0, nums.length-1, target) ;
		
		ans[0] = L ;
		ans[1] = R ;
		
		return ans ;
    }
	
	public static int findL(int[] nums, int l, int r, int target) {
		while(l <= r) {
			int mid = (r + l) /2 ;
			if(nums[mid] < target) {
				l = mid + 1 ;
			} else {
				r = mid - 1 ;
			}
		}
		
		if(l>nums.length-1 || nums[l] != target) return -1 ;
		return l ;
	}
	
	public static int findR(int[] nums, int l, int r, int target) {
		while(l <= r) {
			System.out.println("l:"+l+" r:"+r) ;
			int mid = (r + l) /2 ;
			if(nums[mid] > target) {
				r = mid - 1 ;
			} else {
				l = mid + 1 ;
			}
		}
		
		if(r<0 || nums[r] != target) return -1 ;
		return r ;
	}
}