public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "设置三个数组表示由2， 3， 5相乘后得到的数据集。由第一个‘ugly’树，生成后面可能数据。再从这三个集合中取得最小值并移除。" ;
    
    private int[] dp ;
    
    public int nthUglyNumber(int n) {
        
        int min = Integer.MIN_VALUE ;
        LinkedList<Integer> l2 = new LinkedList<Integer>() ;
        LinkedList<Integer> l3 = new LinkedList<Integer>() ;
        LinkedList<Integer> l5 = new LinkedList<Integer>() ;
        
        l2.add(1) ;
        l3.add(1) ;
        l5.add(1) ;
        
        for(int i=0; i<n; i++) {
            min = Math.min( Math.min(l2.get(0), l3.get(0)), l5.get(0)) ;
            // System.out.println("min: " + min) ;
            
            if (l2.get(0) == min) {
                l2.remove(0) ;
            } 
            if (l3.get(0) == min) {
                l3.remove(0) ;
            } 
            if (l5.get(0) == min)  {
                l5.remove(0) ;
            }
            
            l2.add(min*2) ;
            l3.add(min*3) ;
            l5.add(min*5) ;
        }
        
        return min ;
    }
}
