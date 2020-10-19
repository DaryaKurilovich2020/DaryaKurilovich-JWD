package com.epam.jwd.service;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureCriteria;

import java.util.List;
import java.util.Map;

public interface FigureCrud {
    Figure create(FigureType figureType, Point[] points) throws FigureException;

    Figure findById(int id) throws FigureNotExistException;

    void deleteFigure(Figure figure) throws FigureNotExistException;

    List<Figure> multiCreate(Map<FigureType, List<Point[]>> map);

    void update(Figure figure, Point[] points);

    List<Figure> find(FigureCriteria figureCriteria);
}
