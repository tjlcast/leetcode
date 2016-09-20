package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Combination_Sum_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution_Combination_Sum_39 s = new Solution_Combination_Sum_39() ;
		int[] candidates = {2,3,6,7} ;
		int target = 7 ;
		List<List<Integer>> result = s.combinationSum(candidates, target) ;
		
		Iterator it = result.iterator() ;
		while(it.hasNext()) {
			List<Integer> row = (List<Integer>) it.next() ;
			System.out.println("result: " + row.toString()) ;
		}
	}

}

class Solution_Combination_Sum_39 {
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
    	System.out.println("pos: " + pos + " sum: " + sum) ;
    	if(sum > target) {
    		return ;
    	}
    	
    	if(sum == target) {
    		result.add(new ArrayList<Integer>(row)) ;
    		return ;
    	}
    	
    	for(int i=pos; i<candidates.length; i++) {
    		Integer temp = candidates[i] ;
    		row.add(temp) ;
    		sum += temp ;
    		dfs(candidates, sum, target, i) ;
    		sum -= temp ;
    		row.remove(row.size()-1) ;
    	}
    }
}