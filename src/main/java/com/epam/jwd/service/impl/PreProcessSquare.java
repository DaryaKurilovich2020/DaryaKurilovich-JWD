package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.storage.Storage;
import com.epam.jwd.util.Util;

public class PreProcessSquare extends FigurePreProcessorImpl {
    private static PreProcessSquare preProcessSquare;

    private PreProcessSquare() {
    }

    @Override
    public Figure process(FigureType figureType, Point[] points) throws FigureException {
        Storage storage = Storage.getStorage();
        if (!checkArraySize(FigureType.SQUARE, points)) {
            throw new FigureException("Points array does not suit figure's type");
        }
        if (!checkExistence(points)) {
            throw new FigureException("Square does not exist");
        }
        if (storage.getFigure(points, figureType) != null) {
            return storage.getFigure(points, figureType);
        }
        return null;
    }

    @Override
    public boolean checkArraySize(FigureType figureType, Point[] points) {
        return points.length == 4;
    }

    @Override
    public boolean checkExistence(Point[] points) {
        double side = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (points[i] == points[j])
                    return false;
            }
        }
        if (Util.getLineLength(points[0], points[1]) == Util.getLineLength(points[0], points[2])) {
            if (Util.getKCoefficient(points[0], points[1]) * Util.getKCoefficient(points[0], points[2]) == -1) {
                side = Util.getLineLength(points[0], points[1]);
                return Util.getLineLength(points[1], points[3]) == side && Util.getLineLength(points[2], points[3]) == side;
            }
        } else {
            side = Math.min(Util.getLineLength(points[0], points[1]), Util.getLineLength(points[0], points[2]));
            if (Util.getLineLength(points[2], points[1]) == side) {
                if (Util.getLineLength(points[0], points[1]) == side) {
                    if (Util.getKCoefficient(points[1], points[2]) * Util.getKCoefficient(points[1], points[0]) == -1) {
                        return Util.getLineLength(points[0], points[3]) == side && Util.getLineLength(points[2], points[3]) == side;
                    }
                } else {
                    if (Util.getKCoefficient(points[1], points[2]) * Util.getKCoefficient(points[2], points[0]) == -1) {
                        return Util.getLineLength(points[0], points[3]) == side && Util.getLineLength(points[1], points[3]) == side;
                    }
                }
            }

        }
        return false;
    }

    public static PreProcessSquare getPreProcessSquare() {
        if (preProcessSquare == null){
            preProcessSquare=new PreProcessSquare();
        }
        return preProcessSquare;
    }
}
