class MyCalendarThree {
    private List<int[]> b = new ArrayList<>();

    public MyCalendarThree() {
    }
    
    public int book(int start, int end) {
        b.add(new int[]{start, end, 1});
        int max = b.size() > 0 ? 1 : 0;
        Queue<int[]> queue = new PriorityQueue<>((u, v) -> u[0] == v[0] ? Integer.compare(u[1], v[1]) : Integer.compare(u[0], v[0]));
        for (int[] book: b) queue.offer(book);

        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            if (queue.isEmpty()) break;
            int[] v = queue.poll();
            if (v[0] >= u[1]) queue.offer(v);
            else {
                int[] x, y;
                if (v[1] > u[1]) {
                    x = new int[]{v[0], u[1], u[2] + v[2]};
                    y = new int[]{u[1], v[1], v[2]};
                }
                else {
                    x = new int[]{v[0], v[1], u[2] + v[2]};
                    y = new int[]{v[1], u[1], u[2]};
                }
                queue.offer(x);
                queue.offer(y);
                max = Math.max(max, x[2]);
            }
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
