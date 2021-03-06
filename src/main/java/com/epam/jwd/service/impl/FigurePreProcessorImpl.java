package com.epam.jwd.service.impl;


import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;

import java.util.ArrayList;

public class FigurePreProcessorImpl implements FigurePreProcessor {
    private static FigurePreProcessorImpl figurePreProcessor;
    private static ArrayList<FigurePreProcessor> figurePreProcessors;

    private FigurePreProcessorImpl() {
    }
    public static FigurePreProcessor getInstance(){
        if(figurePreProcessor==null){
            figurePreProcessor=new FigurePreProcessorImpl();
        }
        return figurePreProcessor;
    }

    @Override
    public Figure process(FigureType figureType, Point[] points) throws FigureException {
        switch (figureType) {
            case LINE:
                return PreProcessLine.getPreProcessLine().process(figureType, points);
            case TRIANGLE:
                return PreProcessTriangle.getPreProcessTriangle().process(figureType, points);
            case SQUARE:
                return PreProcessSquare.getPreProcessSquare().process(figureType, points);
            default:
                return null;
        }
    }

    public static void addPreproccesor(FigurePreProcessor figurePreProcessor) {
        figurePreProcessors.add(figurePreProcessor);
    }

    public boolean checkExistence(Point[] points) {
        return true;
    }


    public boolean checkArraySize(FigureType figureType, Point[] points) {
        return true;
    }
}

