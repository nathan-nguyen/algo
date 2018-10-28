# Optimal Strategy

Who would win if both players play optimally.

Need to add predict-the-winner - leetcode

// w[i] - data 
// F[i] - Prediction
F[i] = Max (w[i] + F[i-1]) = Max(w[i] + Min(F[i-2]))

The main idea is that: For the current turn to win, exist the move that all the next turns has to lose.

