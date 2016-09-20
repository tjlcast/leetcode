package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Top_K_Frequent_Elements_347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 1, 1, 2, 2, 3} ;
		int k = 2 ;
		
		Solution_Top_K_Frequent_Elements_347 s = new Solution_Top_K_Frequent_Elements_347() ;
		ArrayList<Integer> ans = (ArrayList<Integer>) s.topKFrequent(nums, k) ;
		
		for(int i=0; i<ans.size(); i++) {
			System.out.print(ans.get(i) + " ") ;
		}System.out.println("") ;
		
	}

}

class Solution_Top_K_Frequent_Elements_347 {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
    	
    	Hashtable<Integer, Integer> table = new Hashtable<>() ;
    	
    	for(int i=0; i<nums.length; i++) {
    		if(table.containsKey(nums[i]) == false) {
    			table.put(nums[i], 0) ;
    		}
    		
    		int tempF = table.get(nums[i]) ;
    		tempF++ ;
    		table.put(nums[i], tempF) ;
    	}
    	
    	ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(table.entrySet()) ;
    	Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
    	}) ;
    	
    	ArrayList<Integer> ans = new ArrayList<>() ;
    	
    	for(int i=0; i<k; i++) {
    		ans.add(list.get(i).getKey()) ;
    	}
    	
    	return ans ;
    }
}

