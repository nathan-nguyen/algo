// -------------------------------------------------------------------------------- //

Basic stuffs: 

1. Check for overflow before submitting.

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

