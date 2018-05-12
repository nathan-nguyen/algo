class MedianFinder {

	private ArrayList<Integer> l = new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        int index = Collections.binarySearch(l, num);
	index = (index >= 0) ? index : -index - 1;
	l.add(index, num);
    }

    public double findMedian() {
        if (l.size() % 2 == 1) return l.get(l.size() / 2);
	else return (double)(l.get(l.size() / 2 - 1) + l.get(l.size() / 2)) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
