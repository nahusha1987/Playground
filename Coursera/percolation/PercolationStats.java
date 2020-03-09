import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {

    private static double CONFIDENCE_95 = 1.96;
    private final int trials;
    private double [] thresholds = null;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        Percolation percolation = null;
        if(n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Values cannot be less than zero");
        }
        this.trials = trials;
        thresholds = new double[trials];
        for(int i = 0; i < trials; i++) {
            percolation = new Percolation(n);
            try {
                while(!percolation.percolates()) {
                    percolation.open(StdRandom.uniform(n), StdRandom.uniform(n));
                }
            }
            catch (IllegalArgumentException exception) {

            }
            thresholds[i] = (double)percolation.numberOfOpenSites()/(n*n);
        }
    }

    // test client (see below)
    public static void main(String[] args) {
        if(args.length != 2) {
            throw new IllegalArgumentException("Provide values for n and T");
        }
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        StdOut.println("mean = " + stats.mean());
        StdOut.println("stddev = " + stats.stddev());
        StdOut.println("95% confidence interval = [" + stats.confidenceLo() + "," + stats.confidenceHi() + "]");
        //System.out.println("mean = " + stats.mean());
        //System.out.println("stddev = " + stats.stddev());
        //System.out.println("95% confidence interval = [" + stats.confidenceLo() + "," + stats.confidenceHi() + "]");

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - (CONFIDENCE_95 * stddev()/ Math.sqrt(this.trials)));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + (CONFIDENCE_95 * stddev()/ Math.sqrt(this.trials)));
    }
}
