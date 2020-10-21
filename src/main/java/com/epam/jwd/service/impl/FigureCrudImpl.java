package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.ApplicationContext;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;
import com.epam.jwd.storage.Storage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FigureCrudImpl implements FigureCrud {
    private final Storage storage;
    FigureFactory figureFactory;

    public FigureCrudImpl(Storage storage, FigureFactory figureFactory) {
        this.storage = storage;
        this.figureFactory = figureFactory;
    }

    private FigureFactory getFigureFactory() {
        return this.figureFactory;
    }

    private Storage getStorage() {
        return this.storage;
    }

    @Override
    public Figure create(FigureType figureType, Point[] points) throws FigureException {
        return ApplicationContext.createFigureFactory().createFigure(figureType, points);
    }

    @Override
    public Figure findById(int id) throws FigureNotExistException {
        List<Figure> figures = getStorage().getFiguresList();
        return figures.stream()
                .filter(figure -> figure.getId() == id)
                .findAny()
                .orElseThrow(() -> new FigureNotExistException("Figure is not exist"));
    }

    @Override
    public void deleteFigure(Figure figure) throws FigureNotExistException {
        Figure figure2 = this.getStorage().getFiguresList().stream()
                .filter(figure::equals)
                .findAny()
                .orElseThrow(() -> new FigureNotExistException("Figure is not exist"));
        this.getStorage().getFiguresList().remove(figure2);
    }

    @Override
    public List<Figure> multiCreate(Map<FigureType, List<Point[]>> map) {
        return map.entrySet().stream().
                flatMap(entry -> createFiguresFromEntries(entry).stream())
                .collect(Collectors.toList());
    }

    private List<Figure> createFiguresFromEntries(Map.Entry<FigureType, List<Point[]>> entry) {
        FigureType figureType = entry.getKey();
        List<Point[]> figurePoints = entry.getValue();
        return figurePoints.stream()
                .map(points -> {
                    try {
                        return create(figureType, points);
                    } catch (FigureException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void update(Figure figure, int id) throws FigureNotExistException {
        Figure toUpdate = this.findById(id);
        this.deleteFigure(toUpdate);
        figure.setId(id);
    }

    @Override
    public List<Figure> find(FigureCriteria criteria) {
        return this.getStorage().getFiguresList().stream()
                .filter(figure -> figure.getFigureType() == criteria.getFigureType())
                .filter(figure -> figure.getId() == criteria.getId())
                .collect(Collectors.toList());
    }
}