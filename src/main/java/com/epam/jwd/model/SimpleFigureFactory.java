package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.strategy.area.LineAreaCounter;
import com.epam.jwd.strategy.area.SquareAreaCounter;
import com.epam.jwd.strategy.area.TriangleAreaCounter;
import com.epam.jwd.strategy.perimeter.LinePerimeterCounter;
import com.epam.jwd.strategy.perimeter.SquarePerimeterCounter;
import com.epam.jwd.strategy.perimeter.CalculateTrianglePerimeter;

public class SimpleFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure(FigureType figureType, Point[] points) throws FigureException {
        Figure figure = null;
        switch (figureType) {
            case LINE:
                figure = new Line(points);
                figure.setSquareCounter(LineAreaCounter.CALCULATE_LINE_AREA);
                figure.setPerimeterCounter(LinePerimeterCounter.getInstance());
                break;
            case TRIANGLE:

                figure = new Triangle(points);
                figure.setSquareCounter(TriangleAreaCounter.getInstance());
                figure.setPerimeterCounter(CalculateTrianglePerimeter.getInstance());
                break;
            case SQUARE:
                figure = new Square(points);
                figure.setSquareCounter(SquareAreaCounter.getInstance());
                figure.setPerimeterCounter(SquarePerimeterCounter.getInstance());
                break;
        }
        return figure;
    }
}
