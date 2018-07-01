import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int TOP = 0;
    private static final int BOTTOM = 1;
    private static final int EXTRA = 2;

    private boolean[][] map;
    private final int dimension;
    private int numberOfOpenSite;
    private final WeightedQuickUnionUF wquuf;
    private final WeightedQuickUnionUF fullWQUUF; 

    // Create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        this.dimension = n;
        this.map = new boolean[n + 2][n + 2];
        this.numberOfOpenSite = 0;
        this.wquuf = new WeightedQuickUnionUF(EXTRA + n * n);
        this.fullWQUUF = new WeightedQuickUnionUF(EXTRA + n * n);
    }

    private void union(int left, int right) {
        wquuf.union(left, right);
        fullWQUUF.union(left, right); 
    }

    // Open site (row, col) if it is not open already
    public void open(int row, int col) {
        this.checkArgument(row, col);

        if (isOpen(row, col)) return;

        map[row][col] = true;
        ++numberOfOpenSite;

        int currentIndex = getIndex(row, col);

        if (row == 1) union(currentIndex, TOP);

        if (map[row - 1][col]) union(currentIndex, getIndex(row - 1, col));
        if (map[row + 1][col]) union(currentIndex, getIndex(row + 1, col));
        if (map[row][col - 1]) union(currentIndex, getIndex(row, col - 1));
        if (map[row][col + 1]) union(currentIndex, getIndex(row, col + 1));

        if (row == dimension) wquuf.union(currentIndex, BOTTOM);
    }

    private void checkArgument(int row, int col) {
        if (row < 1 || col < 1 || row > dimension || col > dimension) throw new IllegalArgumentException();
    }
    
    private int getIndex(int row, int col) {
        return EXTRA + (row - 1) * dimension + (col - 1);
    }

    // Is site (row, col) open?
    public boolean isOpen(int row, int col) {
        this.checkArgument(row, col);
        return map[row][col];
    }

    // Is site (row, col) full
    public boolean isFull(int row, int col) {
        this.checkArgument(row, col);

        if (!isOpen(row, col)) return false;

        return fullWQUUF.connected(getIndex(row, col), TOP);
    }
    
    // Number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }

    // Does the system percolate
    public boolean percolates() {
        return wquuf.connected(TOP, BOTTOM);
    }

}
