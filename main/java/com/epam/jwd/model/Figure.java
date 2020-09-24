package com.epam.jwd.model;

public abstract class Figure {
    private String name;

    public String getName() {
        return name;
    }

    public Figure(String name) {
        this.name = name;
    }
}
