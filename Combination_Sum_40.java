package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Combination_Sum_40 {
	public static void main(String[] args) {
		Solution_Combination_Sum_40 s = new Solution_Combination_Sum_40() ;
		int[] candidates = {10,1,2,7,6,1,5} ;
		int target = 8;
		List<List<Integer>> result = s.combinationSum(candidates, target) ;
		
		
		Iterator it = result.iterator() ;
		while(it.hasNext()) {
			List<Integer> row = (List<Integer>) it.next() ;
			System.out.println("result: " + row.toString()) ;
		}
	}
}


class Solution_Combination_Sum_40 {
	List<List<Integer>> result ;
	List<Integer> row ;
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList() ;
        row = new ArrayList<>() ;
        
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0) ;
        
        return result ;
    }
    
    public void dfs(int[] candidates, int sum, int target, int pos) {
//    	System.out.println("pos: " + pos + " sum: " + sum) ;
    	if(sum > target) {
    		return ;
    	}
    	
    	if(sum == target) {
    		if(!result.contains(row)) {
    			result.add(new ArrayList<Integer>(row)) ;
    		}
    		return ;
    	}
    	
    	for(int i=pos; i<candidates.length; i++) {
    		Integer temp = candidates[i] ;
    		row.add(temp) ;
    		sum += temp ;
    		dfs(candidates, sum, target, i+1) ;
    		sum -= temp ;
    		row.remove(row.size()-1) ;
    	}
    }
}