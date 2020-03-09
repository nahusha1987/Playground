import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {

    private LineSegment[] segments;

    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points
        checkConstraints(points);
        Point[] pointsCopy = Arrays.copyOf(points, points.length);
        List<LineSegment> lineSegmentList = new ArrayList<>();
        Arrays.sort(pointsCopy);
        checkDuplicates(pointsCopy);
        LinkedList<Point> collinearPoints = new LinkedList<Point>();
        for (Point point : pointsCopy) {
            Arrays.sort(pointsCopy, point.slopeOrder());
            double prevSlope = 0.0;
            for (int j = 0; j < pointsCopy.length; j++) {
                double currentSlope = point.slopeTo(pointsCopy[j]);
                if (j == 0 || currentSlope != prevSlope) {
                    if (collinearPoints.size() >= 3) {
                        collinearPoints.add(point);
                        Collections.sort(collinearPoints);
                        if (collinearPoints.contains(point))
                            lineSegmentList.add(new LineSegment(collinearPoints.getFirst(),
                                                                collinearPoints.getLast()));
                    }
                    collinearPoints.clear();
                }
                collinearPoints.add(pointsCopy[j]);
                prevSlope = currentSlope;
            }
        }
        this.segments = lineSegmentList
                .toArray(new LineSegment[lineSegmentList.size()]);
    }

    private void checkConstraints(Point[] input) {
        if (input == null)
            throw new IllegalArgumentException("null argument to constructor");
        for (int i = 0; i < input.length; i++) {
            if (input[i] == null)
                throw new IllegalArgumentException("One of the point in points array is null");
        }
    }

    private void checkDuplicates(Point[] input) {
        for (int i = 0; i < input.length - 1; i++)
            if (input[i].compareTo(input[i + 1]) == 0)
                throw new IllegalArgumentException("Duplicated entries in given points");
    }

    public int numberOfSegments() {
        return this.segments.length;
    }

    public LineSegment[] segments() {
        // the line segments
        return Arrays.copyOf(this.segments, this.segments.length);
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
