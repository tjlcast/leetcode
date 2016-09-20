package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Gray_Code_89 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_Gray_Code_89 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> set = new ArrayList<Integer>() ;
        set.add(0) ;
        
        if(n == 0) return set ;
        set.add(1) ;
        
        int posBit = 2 ;
        for(int i=1; i<n; i++) {
            int len = set.size() ;
            System.out.println("size: " + set.size()) ;
            for(int j=len-1; j>=0; j--) {
                int temp_num = set.get(j) ;
                set.add(temp_num|posBit) ;
            }
            posBit = posBit << 1 ;
        }
        
        return set ;
    }
}