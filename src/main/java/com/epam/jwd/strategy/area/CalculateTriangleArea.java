package com.epam.jwd.strategy.area;

import com.epam.jwd.model.Point;

public class CalculateTriangleArea implements SquareCounter {
    private static CalculateTriangleArea calculateTriangleArea;

    public static CalculateTriangleArea getCalculateAreaInstance() {
        if (calculateTriangleArea == null) {
            calculateTriangleArea = new CalculateTriangleArea();
        }
        return calculateTriangleArea;
    }


    private CalculateTriangleArea() {
    }

    @Override
    public double calculate(Point[] points) {
        double area = 0;
        area = 0.5 * Math.abs((points[1].getX() - points[0].getX()) * (points[2].getY() - points[0].getY())
                - (points[2].getX() - points[0].getX()) * (points[1].getY() - points[0].getY()));
        return area;

    }
}
