package Algorithms;

import java.util.Hashtable;

public class Two_sum_50 {
	public static void main(String[] args) {
		int[] datas = {1, 2, 9, 4, 5} ;
		int[] ans = Solution_Two_sum_50.get(datas, 5) ;
		
		for(int i: ans) {
			System.out.println("i:"+i + " value:"+datas[i]) ;
		}
	}
}


class Solution_Two_sum_50 {
	public static int[] get(int[] data, int target) {
		int[] ans = new int[2] ;
		ans[0] = -1 ;
		ans[1] = -1 ;
		
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>() ;
		for(int i=0; i<data.length; i++) {
			Integer pos = ht.get(data[i]) ;
			if(pos == null)ht.put(data[i], i) ;
			pos = ht.get(target - data[i]) ;
			
			if(pos != null && pos != i) {
				ans[0] = ht.get(data[i]) ;
				ans[1] = pos ;
				return ans ;
			}
		}
	
		return ans ;
	}
}
