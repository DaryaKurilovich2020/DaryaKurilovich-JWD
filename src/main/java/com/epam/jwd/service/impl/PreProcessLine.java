package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigurePreProcessorImpl;
import com.epam.jwd.storage.Storage;

import static com.epam.jwd.model.FigureType.LINE;

public class PreProcessLine extends FigurePreProcessorImpl {
    private static PreProcessLine preProcessLine;

    @Override
    public Figure process(FigureType figureType, Point[] points) throws FigureException {
        Storage storage = Storage.getStorage();

        if (!checkArraySize(LINE, points)) {
            throw new FigureException("Points array does not suit figure's type");
        }
        if (!checkExistence(points)) {
            throw new FigureException("Line does not exist!");

        }
        if (storage.contains(points, figureType) != null) {
            return storage.contains(points, figureType);
        }
        return null;
    }


    @Override
    public boolean checkArraySize(FigureType figureType, Point[] points) {
        return points.length == 2 ? true : false;
    }

    @Override
    public boolean checkExistence(Point[] points) {
        return points[0] == points[1] ? false : true;
    }

    public static PreProcessLine getPreProcessLine() {
        if (preProcessLine != null) return preProcessLine;
        else return new PreProcessLine();
    }

    private PreProcessLine() {
        super();
    }


}
