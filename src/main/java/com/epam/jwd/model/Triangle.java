package com.epam.jwd.model;

public class Triangle extends Figure {
    Triangle(Point[] points) {
        super(FigureType.TRIANGLE, points);
    }

    @Override
    public Point[] getPoints() {
        return super.getPoints();
    }

    @Override
    public Enum getFigureType() {
        return super.getFigureType();
    }

    @Override
    public int getId() {
        return super.getId();
    }


}
