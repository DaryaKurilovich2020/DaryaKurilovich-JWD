package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigurePostProcessorImpl;

public class PostProcessingFactory extends FigureFactoryDecorator {
    private final FigurePostProcessorImpl figurePostProcessor;

    public PostProcessingFactory(FigureFactory factory, FigurePostProcessorImpl figurePostProcessor) {
        super(factory);
        this.figurePostProcessor = figurePostProcessor;
    }


    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {

        Figure figure = super.createFigure(type, figureConstituents).setID();
        return figurePostProcessor.process(figure);
    }
}
