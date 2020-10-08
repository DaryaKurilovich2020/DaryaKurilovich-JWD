package com.epam.jwd.model;

import com.epam.jwd.strategy.area.SquareCounter;
import com.epam.jwd.strategy.perimeter.PerimeterCounter;

public abstract class Figure {
    private Enum figureType;
    private static int id = 0;
    private int ID;
    protected SquareCounter squareCounter;
    protected PerimeterCounter perimeterCounter;
    protected final Point[] points;

    Figure(FigureType figureType, Point[] points) {
        this.points = points;
        this.figureType = figureType;
    }

    public Figure setID() {
        this.ID = ++id;
        return this;
    }

    public Enum getFigureType() {
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

 /*  @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        int count = 0;
        for (int i = 0; i < figure.getPoints().length; i++) {
            for (int j = 0; j < figure.getPoints().length; j++) {
                if (figure.getPoints()[i] == ((Figure) o).getPoints()[j]) {
                    count++;
                    break;
                }
            }
        }
        return Objects.equals(figureType, figure.figureType) && (count == figure.getPoints().length);
    }

  */


  /*  @Override
    public int hashCode() {
        int result = Objects.hash(figureType);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

   */
}
