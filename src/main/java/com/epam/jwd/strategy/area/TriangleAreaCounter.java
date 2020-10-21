package com.epam.jwd.strategy.area;

import com.epam.jwd.model.Point;

public class TriangleAreaCounter implements SquareCounter {
    private static TriangleAreaCounter triangleAreaCounter;

    public static TriangleAreaCounter getInstance() {
        if (triangleAreaCounter == null) {
            triangleAreaCounter = new TriangleAreaCounter();
        }
        return triangleAreaCounter;
    }


    private TriangleAreaCounter() {
    }

    @Override
    public double calculate(Point[] points) {
        return 0.5 * Math.abs((points[1].getX() - points[0].getX()) * (points[2].getY() - points[0].getY())
                - (points[2].getX() - points[0].getX()) * (points[1].getY() - points[0].getY()));
    }
}
