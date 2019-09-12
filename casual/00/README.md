# problem

For a given natural N count the number of N sized binary sequences with no consecutive ones.

Solution:

result = zero + one;

nextZero = zero + one = result;

nextOne = zero = prevResult;

nextResult = nextZero + nextOne = result + prevResult;

