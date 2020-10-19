package com.epam.jwd.model;

import com.epam.jwd.strategy.area.SquareCounter;
import com.epam.jwd.strategy.perimeter.PerimeterCounter;

public abstract class Figure {
    private final FigureType figureType;
    private static int globalId = 0;
    private int id;
    protected SquareCounter squareCounter;
    protected PerimeterCounter perimeterCounter;
    protected Point[] points;

    Figure(FigureType figureType, Point[] points) {
        this.points = points;
        this.figureType = figureType;
    }

    public void setId() {
        this.globalId = ++id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public int getId() {
        return id;
    }

    public double getSquare() {

        return squareCounter.calculate(this.points);
    }

    public Point[] getPoints() {
        return points;
    }

    public double getPerimeter() {
        return perimeterCounter.calculate(this.points);
    }

    public void setPerimeterCounter(PerimeterCounter perimeterCounter) {
        this.perimeterCounter = perimeterCounter;
    }

    public void setSquareCounter(SquareCounter squareCounter) {
        this.squareCounter = squareCounter;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }
}