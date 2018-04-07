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

- Detect cycle in undirected graph

- Easy implementation

// -------------------------------------------------------------------------------- //

