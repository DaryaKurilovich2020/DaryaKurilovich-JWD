package com.epam.jwd.strategy.area;

import com.epam.jwd.lineutility.LineUtility;
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
        double side = Math.min(LineUtility.getLineLength(points[0], points[1]), LineUtility.getLineLength(points[0], points[2]));
        area = Math.pow(side, 2);
        return area;
    }
}
