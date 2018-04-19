# Tufurama

This is draft, dont read these bullshit lines below!

a[i] maximums is n - 1

(i, j) exist <=> a[i] >= j && a[j] >= i

(j, i)

BIT[0, n]

Each season i -> update(a[i], 1)

BIT[i] = number of seasons j that a[j] <= i

Number of eps i >= j

--> k is number of seasons that has i episodes

--> Remove all j that a[j] = i --> update(i, -k)




Constructing Correct Solution:

For each season i -> update(i, 1)

BIT[i] = number of seasons that have index <= i

Condition 1: a[i] >= j

For i = [0, n), consider i as total of episodes number;

get(i) return number of seasons j <= a[k] = i

--> Add get(i)

Step 2: Ensure condition 2: a[j] >= k

Remove all seasons index k (a[k] = i) --> Remaining index will have total eps > i

--> update(k, -1)

