package Algorithms;

public class Number_of_1_Bits_191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Solution_Number_of_1_Bits_191 {
	 // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int tempN = n ;
        int total = 0 ;
        
        while(tempN != 0) {
            if((tempN&1) == 1) {
                total++ ;
            } 
            tempN = tempN >>> 1 ;
            System.out.println("tempN: " + tempN) ;
        }
        
        return total ;
    }
}