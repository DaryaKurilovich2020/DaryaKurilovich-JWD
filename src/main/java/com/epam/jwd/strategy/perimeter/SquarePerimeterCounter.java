package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.model.Point;
import com.epam.jwd.util.Util;

public class SquarePerimeterCounter implements PerimeterCounter {
    private static SquarePerimeterCounter calculatePerimeter;

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
        double side = Math.min(Util.getLineLength(points[0], points[1]), Util.getLineLength(points[0], points[2]));
        return 4 * side;
    }
}
