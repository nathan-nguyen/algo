import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
  private static final double THRESHOLD = 1.96;
  private final int trial;
  private final double mean;
  private final double stddev;

  /**
   * Perform trials indenpendent experiments on an n-by-n grid.
   */
  public PercolationStats(int n, int trial) {
    if (n <= 0 || trial <= 0) {
      throw new IllegalArgumentException();
    }
    this.trial = trial;

    double[] result = new double[trial];
    for (int i = 0; i < trial; ++i) {
      Percolation percolation = new Percolation(n);
      while (!percolation.percolates()) {
        int row = StdRandom.uniform(1, n + 1);
        int col = StdRandom.uniform(1, n + 1);
        percolation.open(row, col);
      }
      result[i] = (double) percolation.numberOfOpenSites() / (n * n);
    }
    this.mean = StdStats.mean(result);
    this.stddev = StdStats.stddev(result);
  }

  // Sample mean of percolation threshold
  public double mean() {
    return this.mean;
  }

  // Sample standard deviation of percolation threshold
  public double stddev() {
    return this.stddev;
  }

  // Low endpoint of 95% confidence interval
  public double confidenceLo() {
    return mean - THRESHOLD * stddev / Math.sqrt(trial);
  }

  // High endpoint of 95% confidence interval
  public double confidenceHi() {
    return mean + THRESHOLD * stddev / Math.sqrt(trial);
  }

  /**
   * Main method - Test client (described below).
   */
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int trial = Integer.parseInt(args[1]);

    PercolationStats percolationStats = new PercolationStats(n, trial);
    System.out.println("mean = " + percolationStats.mean());
    System.out.println("stddev = " + percolationStats.stddev());
    System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", "
        + percolationStats.confidenceHi() + "]");
  }
}

