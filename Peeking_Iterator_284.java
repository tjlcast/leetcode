// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String __tips__ = "向前多扫描一个数" ;
    
    Integer curNum = null;
    boolean isLast = false ;
    Iterator<Integer> iterator = null ;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator ;
	    if (iterator.hasNext()) {
	        curNum = iterator.next() ;
	        if (!iterator.hasNext()) {
	            isLast = true ;
	        } 
	    } 
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return curNum ;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int ans = curNum ;
	    if (isLast==true) {
	        curNum = null ;
	    } else {
	        curNum = iterator.next() ;
	        if (!iterator.hasNext()) {
	            isLast = true ;
	        }
	    }
	    
	    return ans ;
	}
	

	@Override
	public boolean hasNext() {
	    if (curNum == null) {
	        return false ;
	    }
	    return true ;
	}
}
