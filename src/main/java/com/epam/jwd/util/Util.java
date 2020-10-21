package com.epam.jwd.util;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;

public final class Util {
    private Util() {
    }

    public static double getLineLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static double getKCoefficient(Point a, Point b) {
        return (a.getY() - b.getY()) / (a.getX() - b.getX());
    }
    public static boolean pointsEquals(Point[] points1, Point[] points2) {
        int count = 0;
        for (Point point : points1) {
            for (int j = 0; j < points1.length; j++) {
                if (point == points2[j]) {
                    count++;
                    break;
                }
            }
        }
        return count == points1.length;
    }
}
