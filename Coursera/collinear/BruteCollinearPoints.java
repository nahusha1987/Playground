import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points
        checkConstraints(points);
        Point[] pointsCopy = new Point[points.length];
        System.arraycopy(points, 0, pointsCopy, 0, points.length);
        List<LineSegment> lineSegmentList = new ArrayList<>();
        Arrays.sort(pointsCopy);
        checkDuplicates(pointsCopy);
        for (int a = 0; a < pointsCopy.length - 3; a++) {
            for (int b = a + 1; b < pointsCopy.length - 2; b++) {
                for (int c = b + 1; c < pointsCopy.length - 1; c++) {
                    for (int d = c + 1; d < pointsCopy.length; d++) {
                        double slope1 = pointsCopy[a].slopeTo(pointsCopy[b]);
                        double slope2 = pointsCopy[b].slopeTo(pointsCopy[c]);
                        double slope3 = pointsCopy[c].slopeTo(pointsCopy[d]);
                        if ((slope1 == slope2) && (slope1 == slope3)) {
                            LineSegment tempSegment = new LineSegment(pointsCopy[a],
                                                                      pointsCopy[d]);
                            if (!lineSegmentList.contains(tempSegment)) {
                                lineSegmentList.add(tempSegment);
                            }
                        }
                    }
                }
            }
        }
        segments = lineSegmentList
                .toArray(new LineSegment[lineSegmentList.size()]);
    }

    private void checkDuplicates(Point[] input) {
        for (int i = 0; i < input.length - 1; i++)
            if (input[i].compareTo(input[i + 1]) == 0)
                throw new IllegalArgumentException("Duplicated entries in given points");
    }

    private void checkConstraints(Point[] input) {
        if (input == null)
            throw new IllegalArgumentException("null argument to constructor");
        for (Point point : input) {
            if (point == null)
                throw new IllegalArgumentException("One of the point in points array is null");
        }
    }

    public int numberOfSegments() {
        // the number of line segments
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments;
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
