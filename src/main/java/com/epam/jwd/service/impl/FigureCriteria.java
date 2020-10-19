package com.epam.jwd.service.impl;

import com.epam.jwd.model.FigureType;

public class FigureCriteria {
    private final FigureType figureType;
    private final int id;

    private FigureCriteria(FigureType figureType, int id) {
        this.figureType = figureType;
        this.id = id;
    }

    public static CriteriaBuilder builder() {
        return new CriteriaBuilder();
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public int getId() {
        return id;
    }

    private static class CriteriaBuilder {
        private FigureType figureType;
        private int id;

        public CriteriaBuilder() {
        }

        public CriteriaBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CriteriaBuilder figureType(FigureType figureType) {
            this.figureType = figureType;
            return this;
        }

        public FigureCriteria build() {
            return new FigureCriteria(figureType, id);
        }
    }
}
