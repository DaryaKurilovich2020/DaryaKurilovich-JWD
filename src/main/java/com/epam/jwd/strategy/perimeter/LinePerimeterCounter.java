package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.util.Util;
import com.epam.jwd.model.Point;

public class LinePerimeterCounter implements PerimeterCounter {
    private static LinePerimeterCounter linePerimeterCounter;

    public static LinePerimeterCounter getInstance() {
        if (linePerimeterCounter == null) {
            linePerimeterCounter = new LinePerimeterCounter();
        }
        return linePerimeterCounter;
    }

    private LinePerimeterCounter() {
    }


    @Override
    public double calculate(Point[] points) {
        return Util.getLineLength(points[0], points[1]);
    }
}
