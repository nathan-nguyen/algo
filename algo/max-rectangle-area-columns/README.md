# max-rectangle-area-columns

<br/>

leetcode: container-with-most-water

<br/>

## Problem:

Therea are n consecutive columns with height h[i]. The distance between 2 consecutive columns is 1.

The area beween 2 columns i and j is defined as Math.min(h[i], h[j]) * Math.abs(i - j)

Find maximum area between two column.

For example:

<br/>

Input 01:

6

1 3 6 4 5 2

<br/>

Output 01:

15 (Between 6 and 5)

<br/>

## Solution

**Approach from both sides. Each time, calculate the local max area and remove the smaller end.**

<br/>

1 3 6 4 5 2

* Local Max Area = (2 - 1) * 6

* Max Area = 6

<br/>

3 6 4 5 2

* Local Max Area = 2 * 5 = 10

* Max Area = Math.max (10, 6) = 10

<br/>

3 6 4 5

* Local Max Area = 3 * 4 = 12

* Max Area = Math.max(12, 10) = 12

<br/>

6 4 5

* Local Max Area = 5 * 3 = 15

* Max Area = Math.max(15, 12) = 15

<br/>

6 4

* Local max Area = 4 * 2 = 8

* Max Area = Math.max(8, 15) = 15

<br/>

--> Result: 15

