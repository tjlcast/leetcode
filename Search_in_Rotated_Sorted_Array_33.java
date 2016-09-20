package Algorithms;

public class Search_in_Rotated_Sorted_Array_33 {
	public static void main(String[] main) {
		int[] nums = { 1, 3 };
		Solution_Search_in_Rotated_Sorted_Array_33 s = new Solution_Search_in_Rotated_Sorted_Array_33();
		int pos = s.search(nums, 3);
		System.out.println("pos: " + pos);
	}
}

class Solution_Search_in_Rotated_Sorted_Array_33 {
	
	int search(int[] nums, int target) {
		if(nums.length == 0) return -1; 
		
		int l = 0 ;
		int r = nums.length-1; 
		
		while(l <= r) {
			System.out.println("l: "+l+"r: "+r) ;
			int mid = (l + r) >> 1;
			
			if(nums[mid] == target) {
				return mid ;
			}
			
			if(nums[l] <= nums[mid]) {
				if(nums[l]<=target && target<nums[mid]) {
					r = mid-1 ;
				} else {
					l = mid + 1 ;
				}
			} else {
				if(nums[mid]<target && target<=nums[r]) {
					l = mid+1 ;
				} else {
					r = mid-1 ;
				}
			}
		}
		
		return -1 ;
	}

}
