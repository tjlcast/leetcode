public class Solution {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    
    public List<String> fizzBuzz(int n) {
        return work(n) ;
    }
    
    public List<String> work(int n) {
        ArrayList<String> result = new ArrayList<String> () ;
        
        for(int i=1; i<=n; i++) {
            if (i%3==0 && i%5==0) {
                result.add(new String("FizzBuzz")) ;
            } else if (i%3==0) {
                result.add(new String("Fizz")) ;
            } else if (i%5==0) {
                result.add(new String("Buzz")) ;
            } else {
                result.add(i+"") ;
            }
        }
        
        return (List<String>)result ;
    }
}
