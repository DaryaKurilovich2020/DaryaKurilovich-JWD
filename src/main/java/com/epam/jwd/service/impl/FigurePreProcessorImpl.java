package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.lineutility.LineUtility;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;
import com.epam.jwd.storage.Storage;

import java.util.Arrays;

public class FigurePreProcessorImpl implements FigurePreProcessor {


    @Override
    public Figure process(FigureType figureType, Point[] points) throws FigureException {
        Storage storage = Storage.getStorage();
        if (!checkArraySizeSuitsFigureType(figureType, points))
            throw new FigureException("Points array does not suit figure's type");
        if (figureType == FigureType.LINE) {
            if (!checkLineExistence(points)) throw new FigureException("Wrong points!");
        }
        if (figureType == FigureType.TRIANGLE) {
            if (!checkTriangleExistence(points)) throw new FigureException("Wrong points!");
        }
        if (figureType == FigureType.SQUARE) {
            if (!checkSquareExistance(points)) throw new FigureException("Wrong points!");
        }
        if (storage.contains(points, figureType) != null) {
            return storage.contains(points, figureType);
        }
        return null;
    }


    private boolean checkArraySizeSuitsFigureType(FigureType figureType, Point[] points) {
        if (figureType == FigureType.LINE && points.length == 2) return true;
        if (figureType == FigureType.TRIANGLE && points.length == 3) return true;
        if (figureType == FigureType.SQUARE && points.length == 4) return true;
        if (figureType == FigureType.MULTIANGLE && points.length >= 4 && points.length <= 6) return true;
        else return false;
    }

    private static boolean checkLineExistence(Point[] points) {
        return points[0] == points[1] ? false : true;
    }

    private static boolean checkTriangleExistence(Point[] points) {
        double[] lines = new double[]{
                LineUtility.getLineLength(points[0], points[1]),
                LineUtility.getLineLength(points[0], points[2]),
                LineUtility.getLineLength(points[1], points[2])
        };
        Arrays.sort(lines);
        return lines[0] + lines[1] > lines[2] ? true : false;
    }

    private static boolean checkSquareExistance(Point[] points) {
        double side = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (points[i] == points[j])
                    return false;
            }
        }
        if (LineUtility.getLineLength(points[0], points[1]) == LineUtility.getLineLength(points[0], points[2])) {
            if (LineUtility.getKCoefficient(points[0], points[1]) * LineUtility.getKCoefficient(points[0], points[2]) == -1) {
                side = LineUtility.getLineLength(points[0], points[1]);
                if (LineUtility.getLineLength(points[1], points[3]) == side && LineUtility.getLineLength(points[2], points[3]) == side)
                    return true;
            }
        } else {
            side = Math.min(LineUtility.getLineLength(points[0], points[1]), LineUtility.getLineLength(points[0], points[2]));
            if (LineUtility.getLineLength(points[2], points[1]) == side) {
                if (LineUtility.getLineLength(points[0], points[1]) == side) {
                    if (LineUtility.getKCoefficient(points[1], points[2]) * LineUtility.getKCoefficient(points[1], points[0]) == -1) {
                        if (LineUtility.getLineLength(points[0], points[3]) == side && LineUtility.getLineLength(points[2], points[3]) == side)
                            return true;
                    }
                } else {
                    if (LineUtility.getKCoefficient(points[1], points[2]) * LineUtility.getKCoefficient(points[2], points[0]) == -1) {
                        if (LineUtility.getLineLength(points[0], points[3]) == side && LineUtility.getLineLength(points[1], points[3]) == side)
                            return true;
                    }
                }
            }

        }
        return false;
    }
}

