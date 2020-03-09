import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private boolean [][] grid;
    private int numberOfOpenSites;
    private final WeightedQuickUnionUF weightedQuickUnionUF;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("Value of n should be greater than zero (0)");

        this.n = n;
        grid = new boolean[n][n];
        weightedQuickUnionUF = new WeightedQuickUnionUF(n*n + 2);
    }

    // computes the corresponding index in WeightedQuickUnionUF data structure
    private int index(int row, int column) {
        int p = row;
        int q = column;
        //if (p < 0) p = 0;
        //if (q < 0) q = 0;
        return p * this.n + q;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int column) {
        //this.validate(row, column);
        int p = row - 1;
        int q = column - 1;
        if(p < 0 || p >= this.n) {
            throw new IllegalArgumentException("Value specified for row " + row + " is incorrect");
        }
        if(q < 0 || q >= this.n) {
            throw new IllegalArgumentException("Value specified for column " + column + " is incorrect");
        }
        if(isOpen(row, column)) return;
        grid[p][q] = true;
        numberOfOpenSites++;

        if(p == 0) // top row, connect it to top virtual site
            weightedQuickUnionUF.union(this.n*this.n, index(p,q));
        if(p == this.n -1) // bottom row, connect it to bottom virtual site
            weightedQuickUnionUF.union(this.n*this.n + 1, index(p, q));
        // Connect to top element if it exists
        try {
            if(isOpen(row-1,column)) {// top adjacent element
                weightedQuickUnionUF.union(index(p - 1, q), index(p, q));
                if (isFull(row-1, column))
                    weightedQuickUnionUF.union(this.n*this.n, index(p, q));
            }
        } catch (IllegalArgumentException exception) {
            // Do nothing. This is was an element on the edge
        }
        try {
            if(isOpen(row, column-1)) {// left adjacent element
                weightedQuickUnionUF.union(index(p, q - 1), index(p, q));
                if (isFull(row, column - 1))
                    weightedQuickUnionUF.union(this.n*this.n, index(p, q));
            }
        } catch (IllegalArgumentException exception) {
            // Do nothing. This is was an element on the edge
        }
        try {
            if(isOpen(row+1, column)) { // bottom adjacent element
                weightedQuickUnionUF.union(index(p + 1, q), index(p, q));
                if (isFull(row+1, column))
                    weightedQuickUnionUF.union(this.n*this.n, index(p, q));
            }
        } catch (IllegalArgumentException exception) {
            // Do nothing. This is was an element on the edge
        }
        try {
            if(isOpen(row, column+1)) {// right adjacent element
                weightedQuickUnionUF.union(index(p, q + 1), index(p, q));
                if (isFull(row, column + 1))
                    weightedQuickUnionUF.union(this.n*this.n, index(p, q));
            }
        } catch (IllegalArgumentException exception) {
            // Do nothing. This is was an element on the edge
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int column) {
        //this.validate(row, column);
        int p = row - 1;
        int q = column - 1;
        if(p < 0 || p >= this.n) {
            throw new IllegalArgumentException("Value specified for row " + row + " is incorrect");
        }
        if(q < 0 || q >= this.n) {
            throw new IllegalArgumentException("Value specified for column " + column + " is incorrect");
        }
        return grid[p][q];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int column) {
        int p = row - 1;
        int q = column - 1;
        if(p < 0 || p >= this.n) {
            throw new IllegalArgumentException("Value specified for row " + row + " is incorrect");
        }
        if(q < 0 || q >= this.n) {
            throw new IllegalArgumentException("Value specified for column " + column + " is incorrect");
        }
        return weightedQuickUnionUF.connected(this.n*this.n, index(p, q));
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return weightedQuickUnionUF.connected(this.n*this.n, this.n*this.n + 1);
    }

    // test client (optional)
    public static void main(String[] args) {
    /*
    Empty method for testing
     */
    }
}
