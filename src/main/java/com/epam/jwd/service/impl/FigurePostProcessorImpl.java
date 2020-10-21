package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.storage.Storage;

import java.util.ArrayList;

public class FigurePostProcessorImpl implements FigurePostProcessor {
    private static FigurePostProcessorImpl figurePostProcessor;
    private static ArrayList<FigurePostProcessor> figurePostProcessors;

    private FigurePostProcessorImpl() {
    }

    public static FigurePostProcessor getInstance() {
        if (figurePostProcessor == null) {
            figurePostProcessor = new FigurePostProcessorImpl();
        }
        return figurePostProcessor;
    }

    public static void addPostproccesor(FigurePostProcessor figurePostProcessor) {
        figurePostProcessors.add(figurePostProcessor);
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure == null) throw new FigureException("Figure is not exist");
        Storage storage = Storage.getInstance();
        figure.setId();
        storage.addFigure(figure);
        return figure;
    }
}
