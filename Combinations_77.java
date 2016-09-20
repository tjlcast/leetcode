package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 2;

		Solution_Combinations_77 s = new Solution_Combinations_77();
		ArrayList<List> ansSet = (ArrayList) s.combine(n, k);
		
		
		for (int i = 0; i < ansSet.size(); i++) {
			for (int j = 0; j < ansSet.get(i).size(); j++) {
				System.out.print(ansSet.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}

}

class Solution_Combinations_77 {
    
    private Integer[] nums ;
    private ArrayList ansSet ;
    
	public List<List<Integer>> combine(int n, int k) {
	    nums = new Integer[k] ;
	    ansSet = new ArrayList() ;
	    dfs(1, n, k, 0) ;

		return ansSet;
	}
	
	public void dfs(int begin, int n, int k, int pos) {
	        if(pos >= k) {
	            ArrayList tempL = new ArrayList(Arrays.asList(nums)) ;
	            ansSet.add(tempL) ;
	            return ;
	        }
	        
	        for(int i=begin; i<=n; i++) {
	            nums[pos] = i ;
	            dfs(i+1, n, k, pos+1) ;
	        }
	}
}