package com.epam.jwd.model;

public class MultiAngleFigure extends Figure {

    MultiAngleFigure(FigureType figureType, Point[] points) {
        super(figureType, points);
    }

    @Override
    public String toString() {
        return "Multiangle with "+this.getPoints().length+" vertex";
    }
}

