package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.storage.Storage;

import java.util.ArrayList;

public class FigurePostProcessorImpl implements FigurePostProcessor {
    private static FigurePostProcessorImpl figurePostProcessor;
    private static ArrayList<FigurePostProcessor> figurePostProcessors;
    public FigurePostProcessorImpl() {
    }

    public static void addPostproccesor(FigurePostProcessor figurePostProcessor) {
        figurePostProcessors.add(figurePostProcessor);
    }

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure == null) throw new FigureException("Figure is not exist");
        Storage storage = Storage.getStorage();
        figure.setId();
        storage.add(figure);
        return figure;
    }
}
