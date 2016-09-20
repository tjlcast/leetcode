package Algorithms;

public class Implement_strStr_28 {
	public int strStr(String haystack, String needle) {
		int ansPos = -1 ;
		ansPos = haystack.indexOf(needle) ;
		return ansPos;
	}
	
	public static void main(String[] args) {
		Implement_strStr_28 i = new Implement_strStr_28() ;
		int pos = i.strStr("tjn123", "123") ;
		System.out.println("pos: " + pos) ;
	}
}
