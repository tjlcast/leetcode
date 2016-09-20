package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class Remove_Duplicates_from_Sorted_Array_II_80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,1,1,2,2,3} ;
		Solution_Remove_Duplicates_from_Sorted_Array_II s = new Solution_Remove_Duplicates_from_Sorted_Array_II() ;
		s.removeDuplicates(nums) ;
		
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ") ;
		}System.out.println("") ;
		

	}

}

class Solution_Remove_Duplicates_from_Sorted_Array_II {
	public int removeDuplicates(int[] nums) {
		Hashtable<Integer, Integer> recorder = new Hashtable<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int feq = 0;
			if (recorder.containsKey(nums[i]) == true) {
				feq = recorder.get(new Integer(nums[i])) ;
			}
			feq++;

			recorder.put(nums[i], feq);
		}

		ArrayList<Map.Entry<Integer, Integer>> tempList = new ArrayList(recorder.entrySet());
		Collections.sort(tempList, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return ((Entry<Integer, Integer>) o1).getKey() - ((Entry<Integer, Integer>) o2).getKey();
			}
		});

		ArrayList temp  = new ArrayList();
		for (int i = 0; i < tempList.size(); i++) {
			System.out.println("i: " + i + " f: " + tempList.get(i).getKey() + " value: " + tempList.get(i).getValue()) ;
			if (tempList.get(i).getValue() == 1) {
				temp.add(tempList.get(i).getKey());
			} else {
				temp.add(tempList.get(i).getKey());
				temp.add(tempList.get(i).getKey());
			}
		}

		for(int i=0; i<nums.length; i++) {
			if(i < temp.size()) {
				nums[i] = (int) temp.get(i) ;
			} else {
				nums[i] = 0 ;
			}
		}

		return temp.size();
	}
}
