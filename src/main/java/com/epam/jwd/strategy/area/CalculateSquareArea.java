package com.epam.jwd.strategy.area;

import com.epam.jwd.util.Util;
import com.epam.jwd.model.Point;

public class CalculateSquareArea implements SquareCounter {
    private static CalculateSquareArea calculateSquareArea;

    public static  CalculateSquareArea getCalculateSquareAreaInstance() {
        if (calculateSquareArea == null) {
            calculateSquareArea = new CalculateSquareArea();
        }
        return calculateSquareArea;
    }

    private CalculateSquareArea() {
    }

    @Override
    public double calculate(Point[] points) {
        double area = 0;
        double side = Math.min(Util.getLineLength(points[0], points[1]), Util.getLineLength(points[0], points[2]));
        area = Math.pow(side, 2);
        return area;
    }
}
