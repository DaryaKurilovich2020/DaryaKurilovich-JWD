package com.epam.jwd.lineutility;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;

public final class LineUtility {
    private LineUtility() {
    }

    public static double getLineLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public static double getKCoefficient(Point a, Point b) {
        return (a.getY() - b.getY()) / (a.getX() - b.getX());
    }
}
