package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.lineutility.LineUtility;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.area.CalculateSquareArea;

public class CalculateSquarePerimeter implements PerimeterCounter {
    private static CalculateSquarePerimeter calculatePerimeter;

    public static CalculateSquarePerimeter getCalculateSquarePerimeterInstance() {
        if (calculatePerimeter == null) {
            calculatePerimeter = new CalculateSquarePerimeter();
        }
        return calculatePerimeter;
    }

    private CalculateSquarePerimeter() {
    }

    @Override
    public double calculate(Point[] points) {
        double side = Math.min(LineUtility.getLineLength(points[0], points[1]), LineUtility.getLineLength(points[0], points[2]));
        return 4 * side;
    }
}
