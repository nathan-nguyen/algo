class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (u, v) -> Integer.compare(u[1], v[1]));
        Queue<Integer> queue = new PriorityQueue<>((u, v) -> Integer.compare(v, u));
        int totalTime = 0;
        for (int[] c: courses) {
            totalTime += c[0];
            queue.offer(c[0]);
            if (totalTime > c[1]) totalTime -= queue.poll();
        }

        return queue.size();
    }
}
