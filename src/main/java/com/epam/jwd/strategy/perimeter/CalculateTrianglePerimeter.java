package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.Util;

public class CalculateTrianglePerimeter implements PerimeterCounter {
    private static CalculateTrianglePerimeter calculateTrianglePerimeter;

    public static CalculateTrianglePerimeter getCalculateTrianglePerimeterInstance() {
        if (calculateTrianglePerimeter == null) {
            calculateTrianglePerimeter = new CalculateTrianglePerimeter();
        }
        return calculateTrianglePerimeter;
    }

    private CalculateTrianglePerimeter() {
    }

    @Override
    public double calculate(Point[] points) {
        double perimeter = Util.getLineLength(points[0], points[1]) +
                Util.getLineLength(points[0], points[2]) +
                Util.getLineLength(points[1], points[2]);
        return perimeter;
    }
}
