class MyCalendarThree {
    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendarThree() {     
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int max = 0, cur = 0;
        for (int x: map.values()) {
            cur += x;
            max = Math.max(max, cur);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
