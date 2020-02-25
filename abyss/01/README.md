# rotate-array-without-extra-memory

Problem: Given array a size n with O(1), shift element d positions. For example a[i] -> a[(i + d) % n]

First thinking:

There would be k swapping cycles. 0 < k < n

Suppose that first swapping cycle elements are a[i0], a[i1], ..., a[im] with i0 = 0 < i1 < ... < im (It is not neccessary that a[i0] -> a[i1] -> .. a[im] -> a[i0], the swapping order could be different)

Then the next swapping cycle would be a[i0 + 1], a[i1 + 1], ..., a[im + 1]

Two swapping cycles cannot have common element. Therefore the number of cycles are: i1.

- For example: n = 12, d = 9

- First cycle: a[0], a[9], a[6], a[3], a[0], after arrange: a[0], a[3], a[6], a[9]

- The number of cycles are: 3


Second thinking: Juggling algorithm proof

LCM: Lowest common multiple

d cycles if n % d == 0;

Gradually add d / gcd(n,d) number of consecutive arrays with n size right after each other, there would be d cycles.

Let f(x) = (x * d) % n

The answer would be min of f(x) with 0 < x < n / gcd(n, d)

TBU

