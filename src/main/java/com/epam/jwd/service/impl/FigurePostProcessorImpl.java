package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.storage.Storage;

public class FigurePostProcessorImpl implements FigurePostProcessor {
    private static FigurePostProcessorImpl figurePostProcessor;

    public FigurePostProcessorImpl() {
    }



    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure == null) throw new FigureException("Figure is not exist");
        Storage storage = Storage.getStorage();
        figure.setID();
        storage.add(figure);
        return figure;
    }
}
