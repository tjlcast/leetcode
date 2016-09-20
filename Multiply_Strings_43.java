package Algorithms;

import java.util.ArrayList;

public class Multiply_Strings_43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1 = "0183" ;
		String str2 = "2" ;
		Solution_Multiply_Strings_43 s = new Solution_Multiply_Strings_43() ;
		String res = s.multiply(str1, str2) ;
		
		System.out.println("res: " + res);
	}

}


class Solution_Multiply_Strings_43 {
	int[] str1 ;
	int[] str2 ;
	int[] total ;
	
	public String multiply(String str1, String str2) {
		
		if(str1.equals("0") || str2.equals("0")) return "0" ;
		
		this.str1 = new int[str1.length()] ;
		this.str2 = new int[str2.length()] ;
		this.total = new int[str1.length() + str2.length()] ;
		
		for(int i=str1.length()-1; i>=0; i--) {
			this.str1[str1.length()-1-i] = str1.charAt(i) - '0' ;
		}
		
		for(int i=str2.length()-1; i>=0; i--) {
			this.str2[str2.length()-1-i] = str2.charAt(i) - '0' ;
		}
		
		for(int i=0; i<this.str1.length; i++) {
			for(int j=0; j<this.str2.length; j++) {
				total[i + j] += this.str1[i] * this.str2[j] ;
			}
		}
		
		String res = "" ;
		int plus = 0 ;
		for(int i=0; i<total.length; i++) {
			int sum = plus + total[i] ;
			res = (sum%10) + res ;
			plus = sum / 10 ;
		}
		res = res.charAt(0) == '0' ? res.substring(1) : res ;
		return res ;
	}
	
	
}