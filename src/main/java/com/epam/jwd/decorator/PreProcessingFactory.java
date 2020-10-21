package com.epam.jwd.decorator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigurePreProcessorImpl;

public class PreProcessingFactory extends FigureFactoryDecorator {

    private FigurePreProcessorImpl figurePreProcessor;

    public PreProcessingFactory(FigureFactory factory) {
        super(factory);
    }

    @Override
    public Figure createFigure(FigureType type, Point[] figureConstituents) throws FigureException {
        Figure preProcess = FigurePreProcessorImpl.getInstance().process(type, figureConstituents);
        if (preProcess != null) {
            return preProcess;
        }
        Figure figure = super.createFigure(type, figureConstituents);
        return figure;
    }
}
