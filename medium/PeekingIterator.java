// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer num = null;
    private Iterator<Integer> ite = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if(iterator == null) {
	        return;
	    }
	    ite = iterator;
	    num = ite.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return num;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer next = num;
	    num = ite.hasNext() ? ite.next() : null;
	    return next;
	}

	@Override
	public boolean hasNext() {
	    return num != null;
	}
}
