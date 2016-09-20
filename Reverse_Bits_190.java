package Algorithms;

public class Reverse_Bits_190 {
	public static void main(String[] args){
		
	}
}


class Solution_Reverse_Bits_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int m = 0 ;
        for(int i=0;i<32;i++){
            m<<=1;
            m = m|(n & 1);
            n>>=1;
        }
        
        return m ;
    }
}