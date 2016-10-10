class BubbleSort {
	
	public static void sort(int[] arrs) {

		for(int i=0; i<arrs.length; i++)
			for(int j=i+1; j<arrs.length; j++) 
				if (j < arrs.length && arrs[i] > arrs[j]) {
					int temp = arrs[i] ;
					arrs[i] = arrs[j] ;
					arrs[j] = temp ;
				}	
	}

}


public class TestBubbleSort{
	public static void main(String[] args) {
		int arrs[] = {2, 3, 4, 52, 31, 42, 2} ;

		BubbleSort.sort(arrs) ;

		for(int i : arrs) System.out.println(i) ;
	}
}
