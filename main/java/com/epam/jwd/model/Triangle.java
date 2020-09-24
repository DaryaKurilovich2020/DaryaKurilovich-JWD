package com.epam.jwd.model;

public class Triangle extends Figure {
    private Line line1;
    private Line line2;
    private Line line3;

    public Line getLine1() {
        return line1;
    }

    public Line getLine2() {
        return line2;
    }

    public Line getLine3() {
        return line3;
    }

    public void setLine1(Line line1) {
        this.line1 = line1;
    }

    public void setLine2(Line line2) {
        this.line2 = line2;
    }

    public void setLine3(Line line3) {
        this.line3 = line3;
    }

    public Triangle(String name, Line line1, Line line2, Line line3) {
        super(name);
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + "\n" +
                "lines: " + this.getLine1().getName() + " " +
                this.getLine2().getName() + " " +
                this.getLine3().getName();
    }
}
