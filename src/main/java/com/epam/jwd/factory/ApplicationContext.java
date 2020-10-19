package com.epam.jwd.factory;

import com.epam.jwd.decorator.PostProcessingFactory;
import com.epam.jwd.decorator.PreProcessingFactory;
import com.epam.jwd.model.SimpleFigureFactory;
import com.epam.jwd.service.impl.FigurePostProcessorImpl;
import com.epam.jwd.service.impl.FigurePreProcessorImpl;

public class ApplicationContext {
    public static FigureFactory createFigureFactory() {
        return new PostProcessingFactory(new PreProcessingFactory(new SimpleFigureFactory(), new FigurePreProcessorImpl()), new FigurePostProcessorImpl());
    }
}
