package com.epam.jwd.storage;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

import java.util.ArrayList;

public class Storage {
    private static Storage storage;
    private static ArrayList<Figure> figures;

    public static Storage getStorage() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }


    private Storage() {
        ArrayList<Figure> figures = new ArrayList<>();
    }

    public void add(Figure item) {
        getFigures().add(item);
    }


    public Figure getFigure(Point[] points, FigureType figureType) {
        for (Figure figure : getFigures()) {
            if (figure.getFigureType() == figureType && equals(points, figure.getPoints())) {
                return figure;
            }
        }
        return null;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public static boolean equals(Point[] points1, Point[] points2) {
        int count = 0;
        for (Point point : points1) {
            for (int j = 0; j < points1.length; j++) {
                if (point == points2[j]) {
                    count++;
                    break;
                }
            }
        }
        return count == points1.length;
    }
}


