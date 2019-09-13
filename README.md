// -------------------------------------------------------------------------------- //

Basic stuffs: 

1. Check for overflow before submitting.

// -------------------------------------------------------------------------------- //

Basic approaches
- One by one Left to Right
- One by one Right to Left
- All left to right
- All right to left

Greedy:
- Sort, stack, queue, deque

Memory:
- HashMap, HashSet

Data structure:
- Priority Queue, TreeHashMap, Trie, Fenwick Tree (BIT), Segment Tree

Graph:
- (DFS, BFS), (Bellman-Ford, Dijkstra, Floyd-Warshall, Johnson), (Prim, Kruskal), Union-Find

Methods:
- Brute Forces, Greedy, DP

// -------------------------------------------------------------------------------- //
1. Line equation

x1 = ?  ;  y1 = ? ;    // First diagonal point
x2 = ?  ;  y2 = ? ;    // Second diagonal point

xc = (x1 + x2)/2  ;  yc = (y1 + y2)/2  ;    // Center point
xd = (x1 - x2)/2  ;  yd = (y1 - y2)/2  ;    // Half-diagonal

x3 = xc - yd  ;  y3 = yc + xd;    // Third corner
x4 = xc + yd  ;  y4 = yc - xd;    // Fourth corner

// Line equation passing (x1, y1) and (x2, y2)
(y2 - y1) * x + (x1 - x2) * y = x1 * y2 - x2 * y1

Example: Hackerrank: a-circle-and-a-square

// -------------------------------------------------------------------------------- //

2. Removing vertices from graph

For the problem of removing one-by-one vertex from graph, we can solve by reversing the order of removing. That means insteading of removing, we start with empty graph and keep adding one-by-one vertex.

Example: Codeforces 295B

- Remove vertices such that the remaining vertices still form a connected graph. This is a simple dfs problem.

// -------------------------------------------------------------------------------- //

3. Weighted Quick Union

- Union find

- Easy implementation

// -------------------------------------------------------------------------------- //

4. Array of n distinct elements from 1 to n

- This problem might be converted to linked list problem.

- The value of 1 element is the index of the next element.

Example: Leetcode find-the-duplicate-number

// -------------------------------------------------------------------------------- //

5. Binary Indexed Tree (BIT) - Fenwick tree

- Easy implementation

- [0 - n] : Node 0 is a dummy node

- get(index): index++; --> while index > 0 --> index -= index & (-index);

- update(index, increasingVal): index++; --> while index <=n --> index += index & (-index);

// -------------------------------------------------------------------------------- //

6. Find cycle in directed graph

- Keep a stack

- If vertex is in stack -> cycle

- else stack.push(vertex); --> process vertex's children --> Remove vertex from stack: stack.pop();

// -------------------------------------------------------------------------------- //

7. Simple calculation

2 ^ n --> 1 << n

(int) log2(n) --> (int) (Math.log(n) / Math.log(2))

// -------------------------------------------------------------------------------- //

8. LinkedList

- Dont hesitate to use extra variables to simplize the problem

// -------------------------------------------------------------------------------- //

9. String problems

- Two pointers
- Dynamic programming
- Recursive
- Start from letter a - z (Consider each letter position, start with positions of all letter a)
- Start from letter z - a (Consider each letter position, start with positions of all letter z)

// -------------------------------------------------------------------------------- //

10. Detect cycle in undirected graph

- Use simple dfs O(n)

// -------------------------------------------------------------------------------- //

11. When dealing with overlapping elements, consider combining non-overlapping elements instead of dividing them into multiple small elements.

Example: Leetcode meeting-rooms-ii

// -------------------------------------------------------------------------------- //

12. Depth First Search

When the graph contains loops **and** parent value depends on child value, using DFS is **not recommended**.

If the graph is DAG, it is safe to use DFS.

// -------------------------------------------------------------------------------- //

13. Rectangle overlap

(x1, y1), (x2, y2)  ; x1 <= x2 ; y1 <= y2
(x3, y3), (x4, y4)  ; x3 <= x4 ; y3 <= y4

Overlap rectangle:
x5 = Math.max(x1, x3)
y5 = Math.max(y1, y3)
x6 = Math.max(x5, Math.min(x2, x4))
y6 = Math.max(x6, Math.min(y2, y4))

// -------------------------------------------------------------------------------- //

14. Complexity to find all divisors of n is O(sqrt(n))

for (int i = 1; i * i <= n) if (n % i == 0), we have i and n / i

// -------------------------------------------------------------------------------- //

15. Count connected component

- Use DFS - O(n)

- Use Union-Find - O(n log n)

// -------------------------------------------------------------------------------- //

16. Count number of pairs [l, r] in array

- Find the relation betweek [0, l-1] and [0, r]

// -------------------------------------------------------------------------------- //

17. Given an array a length n. Let's say dp[i] is the answer for the first ith elements.

One approach which has complexity of O(n*n) is that compare dp[i] with dp[k] for k: [0 -> i) and find (a[k+1] to a[i]) condition. Because dp[i-k] is always the answer for first i-k elements.

