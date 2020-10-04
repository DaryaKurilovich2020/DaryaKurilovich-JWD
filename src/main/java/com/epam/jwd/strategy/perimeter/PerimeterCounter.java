package com.epam.jwd.strategy.perimeter;

import com.epam.jwd.model.Point;

public interface PerimeterCounter {
    public double calculate(Point[] points);
}
