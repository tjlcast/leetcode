package Algorithms;

public class Reverse_String_344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello" ;
		s = Solution_Reverse_String_344.reverseString(s) ;
		System.out.println("str: " + s) ; 
	}

}


class Solution_Reverse_String_344 {
	public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s) ;
        sb.reverse() ;
        s = sb.toString() ;
        return s ;
    }
}