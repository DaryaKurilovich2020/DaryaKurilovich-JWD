package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.strategy.area.CalculateLineArea;
import com.epam.jwd.strategy.area.CalculateSquareArea;
import com.epam.jwd.strategy.area.CalculateTriangleArea;
import com.epam.jwd.strategy.perimeter.CalculateLinePerimeter;
import com.epam.jwd.strategy.perimeter.CalculateSquarePerimeter;
import com.epam.jwd.strategy.perimeter.CalculateTrianglePerimeter;

public class SimpleFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure(FigureType figureType, Point[] points) throws FigureException {
        Figure figure = null;
        switch (figureType) {
            case LINE:
                figure = new Line(points);
                figure.setSquareCounter(CalculateLineArea.CALCULATE_LINE_AREA);
                CalculateLinePerimeter calculateLinePerimeter = CalculateLinePerimeter.getCalculateLinePerimeterInstance();
                figure.setPerimeterCounter(calculateLinePerimeter);
                break;
            case TRIANGLE:

                figure = new Triangle(points);
                CalculateTriangleArea calculateTriangleArea = CalculateTriangleArea.getCalculateAreaInstance();
                figure.setSquareCounter(calculateTriangleArea);
                CalculateTrianglePerimeter calculateTrianglePerimeter = CalculateTrianglePerimeter.getCalculateTrianglePerimeterInstance();
                figure.setPerimeterCounter(calculateTrianglePerimeter);
                break;
            case SQUARE:
                figure = new Square(points);
                CalculateSquareArea calculateSquareArea = CalculateSquareArea.getCalculateSquareAreaInstance();
                figure.setSquareCounter(calculateSquareArea);
                CalculateSquarePerimeter calculateSquarePerimeter = CalculateSquarePerimeter.getCalculateSquarePerimeterInstance();
                figure.setPerimeterCounter(calculateSquarePerimeter);
                break;
        }
        return figure;
    }
}
