package Algorithms;

public class Reverse_Vowels_of_a_String_345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ee";
		Solution_Reverse_Vowels_of_a_String_345 s = new Solution_Reverse_Vowels_of_a_String_345();
		str = s.reverseVowels(str);
		// System.out.println("str: " + str) ;
	}

}

class Solution_Reverse_Vowels_of_a_String_345 {
	char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

	public String reverseVowels(String s) {
		int l = 0;
		int r = s.length() - 1;

		char[] arr = s.toCharArray();

		while (l <= r) {
			while (l <= r && !isVowel(arr[l])) {
				// System.out.println("l: " + l) ;
				l++;
			}
			//System.out.println("qwr: " + r);
			while (l <= r && !isVowel(arr[r])) {
				// System.out.println("r: " + r) ;
				r--;
			}

			if (l <= r) {
				char word = arr[r];
				arr[r] = arr[l];
				arr[l] = word;
			}
			r--;
			l++;
		}

		return new String(arr);
	}

	public boolean isVowel(char word) {
		boolean ans = false;
		for (int i = 0; i < vowels.length; i++) {
			if (word == vowels[i])
				ans = true;
		}
		return ans;
	}
}