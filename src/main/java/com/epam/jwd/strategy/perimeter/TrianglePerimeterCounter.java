package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.Util;

public class TrianglePerimeterCounter implements PerimeterCounter {
    private static TrianglePerimeterCounter calculateTrianglePerimeterCounter;

    public static TrianglePerimeterCounter getInstance() {
        if (calculateTrianglePerimeterCounter == null) {
            calculateTrianglePerimeterCounter = new TrianglePerimeterCounter();
        }
        return calculateTrianglePerimeterCounter;
    }

    private TrianglePerimeterCounter() {
    }

    @Override
    public double calculate(Point[] points) {
        return getSideLength(points[0], points[1]) +
                getSideLength(points[0], points[2]) +
                getSideLength(points[1], points[2]);
    }

    private static double getSideLength(Point a, Point b) {
        return Util.getLineLength(a, b);
    }
}
