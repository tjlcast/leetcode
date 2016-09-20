package Algorithms;

import java.util.Hashtable;

public class Unique_Binary_Search_Trees_96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 3 ;
		
		Solution_Unique_Binary_Search_Trees_96 s = new Solution_Unique_Binary_Search_Trees_96() ;
		int ans = s.numTrees(n) ;
		
		System.out.println("ans: " + ans) ;
	}

}


class Solution_Unique_Binary_Search_Trees_96 {
	
	private Hashtable<Integer, Integer> recorder ;
	
    public int numTrees(int n) {
    	recorder = new Hashtable<>() ;
        int ans = dfs2(n) ;
        return ans ;
    }	
    
    public int dfs(int n) {
    	int total = 0 ;
    	if(n == 0) {
    		return 1 ;
    	}
    	if(n == 1) {
    		return 1 ;
    	}
    	
    	if(recorder.contains(n)) {
    		return recorder.get(n) ;
    	}
    	
    	for(int i=0; i<n; i++) {
    		
    		int sum1 = dfs(i ) ;
    		int sum2 = dfs(n - i - 1) ;
    		if(i == n-1-i) {
    			
    		}
    		total += ( sum1 * sum2 );
    	}
    	recorder.put(n, total) ;
    	
    	return total ;
    }
    
    public int dfs2(int n) {
    	int[] dp = new int[n+1] ;
    	dp[0] = 1 ;
    	dp[1] = 1 ;
    	
    	for(int i=2; i<dp.length; i++) {
    		for(int j=0; j<i; j++) {
    			dp[i] += dp[j] * dp[i - j -1] ;
    		}
    	}
    	
    	return dp[n] ;
    }
}