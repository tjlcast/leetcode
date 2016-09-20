package Algorithms; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubSet_78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1} ;
		
		Solution_SubSet_78 s = new Solution_SubSet_78() ;
		List<List<Integer>> ansSet = (ArrayList) s.subsets(nums) ;
		
		
		for(int i=0; i<ansSet.size(); i++) {
			for(int j=0; j<ansSet.get(i).size(); j++) {
				System.out.print(ansSet.get(i).get(j) + " ") ;
			}System.out.println("") ;
		}
	}

}


class Solution_SubSet_78 {
    private Integer[] gList ;
    private ArrayList ansSet ;
    
    public List<List<Integer>> subsets(int[] nums) {
    	mySort(nums) ;
        gList = new Integer[nums.length] ;
        ansSet = new ArrayList() ;
        ArrayList<Integer> temp = new ArrayList<Integer>() ;
        ansSet.add(temp) ;
        if(nums.length == 0) {
        	return ansSet ;
        }
        
        
        
        dfs(0, nums, 0) ;
        
        return ansSet ;
    }
    
    public void dfs(int pos, int[] nums, int k) {
    	if(pos >= nums.length || k>=nums.length) {
    		return ;
    	}
        
    
        for(int i=k; i<nums.length; i++) {
            gList[pos] = nums[i] ;
            Integer[] temp = new Integer[pos+1] ;
            for(int j=0; j<=pos; j++) {
            	temp[j] = gList[j] ;
            }
            ansSet.add(new ArrayList(Arrays.asList(temp))) ;
            dfs(pos+1, nums, i+1) ;
        }
        
        return ;
    }
    
    private void mySort(int[] nums) {
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