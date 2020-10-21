package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.Util;

public class SquarePerimeterCounter implements PerimeterCounter {
    private static SquarePerimeterCounter calculatePerimeter;
    private static final int SQUARE_INT=4;

    public static SquarePerimeterCounter getInstance() {
        if (calculatePerimeter == null) {
            calculatePerimeter = new SquarePerimeterCounter();
        }
        return calculatePerimeter;
    }

    private SquarePerimeterCounter() {
    }

    @Override
    public double calculate(Point[] points) {
        return SQUARE_INT * getSideLength(points);
    }

    private static double getSideLength(Point[] points) {
        return Math.min(Util.getLineLength(points[0], points[1]), Util.getLineLength(points[0], points[2]));
    }
}
