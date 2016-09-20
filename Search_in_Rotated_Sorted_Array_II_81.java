package Algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class Search_in_Rotated_Sorted_Array_II_81 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 1, 2, 3} ;
		int target = 2 ;
		Solution_Search_in_Rotated_Sorted_Array_II_81 s = new Solution_Search_in_Rotated_Sorted_Array_II_81() ;
		boolean ans = s.search(nums, target) ;
		
		if(ans == true) {
			System.out.println("Yes") ;
		} else {
			System.out.println("No") ;
		}
	}

}

class Solution_Search_in_Rotated_Sorted_Array_II_81 {
    public boolean search(int[] nums, int target) {
        ArrayList<Integer> temp_nums = new ArrayList<Integer>() ;
        for(int i=0; i<nums.length; i++) {
            if(temp_nums.contains(nums[i]) == false) {
                temp_nums.add(nums[i]) ;
            }
        }
        Collections.sort(temp_nums) ;
        int[] nums_list = new int[temp_nums.size()] ;
        for(int i=0; i<temp_nums.size(); i++) {
            nums_list[i] = temp_nums.get(i) ;
        }
        
        int ans = find(nums_list, target) ;
        if(ans == -1) {
            return false ;
        } else {
            return true ;
        }
    }
    
    public int find(int[] nums, int target) {
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