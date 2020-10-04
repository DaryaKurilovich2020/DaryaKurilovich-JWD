package com.epam.jwd.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.service.impl.FigurePostProcessorImpl;
import com.epam.jwd.service.impl.FigurePreProcessorImpl;
import com.epam.jwd.strategy.area.CalculateLineArea;
import com.epam.jwd.strategy.area.CalculateSquareArea;
import com.epam.jwd.strategy.area.CalculateTriangleArea;
import com.epam.jwd.strategy.perimeter.CalculateLinePerimeter;
import com.epam.jwd.strategy.perimeter.CalculateSquarePerimeter;
import com.epam.jwd.strategy.perimeter.CalculateTrianglePerimeter;

public class FigureFactory {

    public static Figure getFigure(Point[] points, FigureType figureType) throws FigureException {
        Figure figure = null;
FigurePreProcessorImpl figurePreProcessor=new FigurePreProcessorImpl() ;
        FigurePostProcessorImpl figurePostProcessor=new FigurePostProcessorImpl();
        switch (figureType) {
            case LINE:
                figurePreProcessor.process(figureType, points);
                figure = new Line(points);
                figure = figurePostProcessor.process(figure);
                figure.setSquareCounter(CalculateLineArea.CALCULATE_LINE_AREA);
                CalculateLinePerimeter calculateLinePerimeter = CalculateLinePerimeter.getCalculateLinePerimeterInstance();
                figure.setPerimeterCounter(calculateLinePerimeter);
                break;
            case TRIANGLE:
                figurePreProcessor.process(figureType, points);

                figure = new Triangle(points);
                figure = figurePostProcessor.process(figure);
                CalculateTriangleArea calculateTriangleArea = CalculateTriangleArea.getCalculateAreaInstance();
                figure.setSquareCounter(calculateTriangleArea);
                CalculateTrianglePerimeter calculateTrianglePerimeter = CalculateTrianglePerimeter.getCalculateTrianglePerimeterInstance();
                figure.setPerimeterCounter(calculateTrianglePerimeter);
                break;
            case SQUARE:
                figurePreProcessor.process(figureType, points);
                figure = new Square(points);
                figure = figurePostProcessor.process(figure);
                CalculateSquareArea calculateSquareArea = CalculateSquareArea.getCalculateSquareAreaInstance();
                figure.setSquareCounter(calculateSquareArea);
                CalculateSquarePerimeter calculateSquarePerimeter = CalculateSquarePerimeter.getCalculateSquarePerimeterInstance();
                figure.setPerimeterCounter(calculateSquarePerimeter);
                break;
            case MULTIANGLE:
                figurePreProcessor.process(figureType, points);
                figure = new MultiAngleFigure(figureType, points);
                figure = figurePostProcessor.process(figure);


        }
        return figure;
    }

    private FigureFactory() {
    }
}
