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
        return Util.getLineLength(points[0], points[1]) +
                Util.getLineLength(points[0], points[2]) +
                Util.getLineLength(points[1], points[2]);
    }
}
