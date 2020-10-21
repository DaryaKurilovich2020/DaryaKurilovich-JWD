package com.epam.jwd.strategy.area;

import com.epam.jwd.util.Util;
import com.epam.jwd.model.Point;

public class SquareAreaCounter implements SquareCounter {
    private static SquareAreaCounter squareAreaCounter;

    public static SquareAreaCounter getInstance() {
        if (squareAreaCounter == null) {
            squareAreaCounter = new SquareAreaCounter();
        }
        return squareAreaCounter;
    }

    private SquareAreaCounter() {
    }

    @Override
    public double calculate(Point[] points) {
        double side = Math.min(Util.getLineLength(points[0], points[1]), Util.getLineLength(points[0], points[2]));
        return Math.pow(side, 2);
    }
}
