package com.epam.jwd.strategy.area;

import com.epam.jwd.model.Point;

public enum CalculateLineArea implements SquareCounter {
    CALCULATE_LINE_AREA;

    @Override
    public double calculate(Point[] points) {
        return 0;
    }

}
