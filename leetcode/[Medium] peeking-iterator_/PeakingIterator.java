// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

        private List<Integer> l = new ArrayList<>();
        private int current = 0;
        
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    while (iterator.hasNext()) l.add(iterator.next());
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
                return l.get(current);
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
                return current < l.size() ? l.get(current++) : null;
	}

	@Override
	public boolean hasNext() {
	    return current < l.size();
	}
}

