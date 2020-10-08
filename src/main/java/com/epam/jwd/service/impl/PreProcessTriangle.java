package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.storage.Storage;
import com.epam.jwd.util.Util;

import java.util.Arrays;

public class PreProcessTriangle extends FigurePreProcessorImpl {
    private static PreProcessTriangle preProcessTriangle;

    private PreProcessTriangle() {
    }

    @Override
    public Figure process(FigureType figureType, Point[] points) throws FigureException {
        Storage storage = Storage.getStorage();
        if (!checkArraySize(FigureType.TRIANGLE, points)) {
            throw new FigureException("Points array does not suit figure's type");
        }
        if (!checkExistence(points)) {
            throw new FigureException("Triangle does not exist");
        }
        if (storage.contains(points, figureType) != null) {
            return storage.contains(points, figureType);
        }
        return null;
    }

    @Override
    public boolean checkArraySize(FigureType figureType, Point[] points) {
        return points.length == 3 ? true : false;
    }

    @Override
    public boolean checkExistence(Point[] points) {
        double[] lines = new double[]{
                Util.getLineLength(points[0], points[1]),
                Util.getLineLength(points[0], points[2]),
                Util.getLineLength(points[1], points[2])
        };
        Arrays.sort(lines);
        return lines[0] + lines[1] > lines[2] ? true : false;
    }


    public static PreProcessTriangle getPreProcessTriangle() {
        if (preProcessTriangle != null) return preProcessTriangle;
        else return new PreProcessTriangle();
    }


}
