package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.storage.Storage;

import java.util.List;

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
        if (storage.getFigure(points, figureType) != null) {
            return storage.getFigure(points, figureType);
        }
        return null;
    }


    @Override
    public boolean checkArraySize(FigureType figureType, Point[] points) {
        return points.length == 2;
    }

    @Override
    public boolean checkExistence(Point[] points) {
        return points[0] != points[1];
    }

    public static PreProcessLine getPreProcessLine() {
        if (preProcessLine == null){
            preProcessLine=new PreProcessLine();
        }
        return preProcessLine;
    }

  private PreProcessLine(){

  }
}
