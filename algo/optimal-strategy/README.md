# Optimal Strategy

Who would win if both players play optimally.

Need to add predict-the-winner - leetcode

// w[i] - data 
// F[i] - Prediction
F[i] = Max (w[i] + F[i-1]) = Max(w[i] + Min(F[i-2]))

