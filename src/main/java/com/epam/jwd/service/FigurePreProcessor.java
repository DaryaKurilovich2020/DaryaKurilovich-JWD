package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigurePreProcessor {
    Figure process(FigureType figureType, Point[] points) throws FigureException;

}
