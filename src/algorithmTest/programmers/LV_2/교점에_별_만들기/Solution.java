package algorithmTest.programmers.LV_2.교점에_별_만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public Point pointSavefilter(long a1, long b1, long c1, long a2, long b2, long c2) {

        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }
        if (a1 * b2 - b1 * a2 == 0) {
            return null;
        }

        return new Point((int) x, (int) y);
    }

    public Point getMaxPoint(List<Point> points) {
        int maxX = -1001;
        int maxY = -1001;
        for (Point point : points) {
            maxX = maxX < point.getX() ? point.getX() : maxX;
            maxY = maxY < point.getY() ? point.getY() : maxY;
        }
        return new Point(maxX, maxY);
    }

    public Point getMinPoint(List<Point> points) {
        int minX = 1001;
        int minY = 1001;
        for (Point point : points) {
            minX = minX > point.getX() ? point.getX() : minX;
            minY = minY > point.getY() ? point.getY() : minY;
        }
        return new Point(minX, minY);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; i < line.length; j++) {
                if (j == line.length) {
                    break;
                }
                Point point = pointSavefilter(line[i][0], line[i][1], line[i][2],
                    line[j][0], line[j][1], line[j][2]);
                if (point != null) {
                    points.add(point);
                }
            }
        }

        Point minPoint = getMinPoint(points);
        Point maxPoint = getMaxPoint(points);

        int width = (maxPoint.getX() - minPoint.getX() + 1);
        int height = (maxPoint.getY() - minPoint.getY() + 1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x = (int) (p.getX() - minPoint.getX());
            int y = (int) (maxPoint.getY() - p.getY());
            arr[y][x] = '*';
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }
}

