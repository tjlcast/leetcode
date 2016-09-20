package Algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class Group_Anagrams_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"} ;
		Solution_Group_Anagrams_49 s = new Solution_Group_Anagrams_49() ;
		ArrayList ans = (ArrayList) s.groupAnagrams(strs) ;
		
		for(int i=0; i<ans.size(); i++) {
			ArrayList row = (ArrayList) ans.get(i) ;
			for(int j=0; j<row.size(); j++) {
				System.out.print(row.get(j) + " ") ;
			}
			System.out.println("") ;
		}
	}

}

class Solution_Group_Anagrams_49 {
	Hashtable<String, ArrayList> ansSet ;
	
	public Solution_Group_Anagrams_49() {
		ansSet = new Hashtable<>() ;
	}
	
    public List<List<String>> groupAnagrams(String[] strs) {
        divide(strs);
        
        ArrayList ansList = new ArrayList() ;
        for(String key : ansSet.keySet()) {
        	ArrayList row = ansSet.get(key) ;
        	Collections.sort(row);
        	ansList.add(row) ;
        }
        
        return ansList ;
    }
    
    public void divide(String[] strs) {
    	for(int i=0; i<strs.length; i++) {
    		String key = getKey(strs[i]) ;
    		if(!ansSet.containsKey(key)){
    			ArrayList list = new ArrayList<>() ;
    			list.add(strs[i]) ;
    			ansSet.put(key, list) ;
    		} else {
    			ansSet.get(key).add(strs[i]) ;
    		}
    	}
    	
    	return ;
    }
    
    public String getKey(String str) {
    	StringBuffer sb = new StringBuffer(str) ;
    	for(int i=0; i<sb.length()-1; i++) {
    		for(int j=i+1; j<sb.length(); j++) {
    			if(sb.charAt(i)-'0' > sb.charAt(j)-'0') {
    				char word = sb.charAt(i) ;
    				sb.setCharAt(i, sb.charAt(j));
    				sb.setCharAt(j, word);
    			}
    		}
    	}
    	return sb.toString() ;
    }
}