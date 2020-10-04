package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.lineutility.LineUtility;
import com.epam.jwd.model.Point;

public class CalculateLinePerimeter implements PerimeterCounter {
    private static CalculateLinePerimeter calculateLinePerimeter;

    public static CalculateLinePerimeter getCalculateLinePerimeterInstance() {
        if (calculateLinePerimeter == null) {
            calculateLinePerimeter = new CalculateLinePerimeter();
        }
        return calculateLinePerimeter;
    }

    private CalculateLinePerimeter() {
    }


    @Override
    public double calculate(Point[] points) {
        double perimeter = 0;
        LineUtility.getLineLength(points[0],points[1]);
        return perimeter;
    }
}
