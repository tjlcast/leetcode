package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Permutations_46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,0,0,1,-1,-1,1} ;
		Solution_Permutations_46 s = new Solution_Permutations_46() ;
		List<List<Integer>> ans = s.permute(nums) ;
		
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i).size() + "row: ") ;
			List tempRow = ans.get(i) ;
			for(int j=0; j<tempRow.size(); j++) {
				System.out.print(tempRow.get(j) + " ") ;
			}
			System.out.println("");
		}
		
	}

}

class Solution_Permutations_46 {
	ArrayList ans ;
	
    public List<List<Integer>> permute(int[] nums) {
    	ans = new ArrayList() ;
//    	if(nums.length == 0) {
//    		ans.add(new ArrayList()) ;
//    		return ans ;
//    	}
//    	
    	generate(nums, 0, nums.length-1);
    	
    	return ans ;
    }
    
    public void generate(int[] nums, int l, int r) {
    	
    	if(l >= r) {
    		ArrayList temp = new ArrayList() ;;
    		for(int i=0; i<nums.length; i++) {
    			temp.add(nums[i]) ;
    		}
    		if(!ans.contains(temp))ans.add(temp) ;
    		return ;
    	}
    	
    	for(int i=l; i<=r; i++) {
    		change(nums, l, i) ;
    		generate(nums, l+1, r) ;
    		change(nums, l, i) ;
    	}
    }
    
    public void change(int[] nums, int pos1, int pos2) {
    	if(pos1 < 0 || pos1 >= nums.length) return ;
    	if(pos2 < 0 || pos2 >= nums.length) return ;
    	
    	int temp = nums[pos1] ;
    	nums[pos1] = nums[pos2] ;
    	nums[pos2] = temp ;
    }
   
}