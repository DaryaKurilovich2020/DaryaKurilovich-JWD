package com.epam.jwd.storage;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.util.Util;
import java.util.ArrayList;

public class Storage {
    private static Storage storage;
    private static ArrayList<Figure> figures;

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    private Storage() {
        ArrayList<Figure> figures = new ArrayList<>();
    }

    public void addFigure(Figure item) {
        getFiguresList().add(item);
    }

    public Figure getFigure(Point[] points, FigureType figureType) {
        for (Figure figure : getFiguresList()) {
            if (figure.getFigureType() == figureType && Util.pointsEquals(points, figure.getPoints())) {
                return figure;
            }
        }
        return null;
    }

    public ArrayList<Figure> getFiguresList() {
        return figures;
    }
}


