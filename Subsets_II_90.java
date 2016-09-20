package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets_II_90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Subsets_II_90 {
    private int[] record ;
    private ArrayList set ;
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        record = new int[nums.length] ;
        set = new ArrayList() ;
        set.add(new ArrayList<Integer>()) ;
        if(nums.length == 0) {
            return set ;
        }
        
        sort(nums) ;
        dfs(0, nums, 0) ;
        
        return set ;
    }
    
    public void dfs(int pos, int[] nums, int k) {
        if(pos >= nums.length || k >= nums.length) {
            return ;
        }
    
        for(int i=k; i<nums.length; i++) {
            record[pos] = nums[i] ;
            
            ArrayList<Integer> temp_list = new ArrayList<Integer>() ;
            for(int j=0; j<=pos; j++) {
            	temp_list.add(record[j]) ;
            }
            
            if(set.contains(temp_list) == false) {
                set.add(temp_list) ;
            }
            
            dfs(pos+1, nums, i+1) ;
        }
        
        return ;
    }
    
    public void sort(int[] nums) {
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