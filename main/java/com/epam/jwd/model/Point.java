package com.epam.jwd.model;

public class Point extends Figure {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(String name, final double x, final double y) {
        super(name);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + "\n" +
                "x: " + this.getX() + "\n" +
                "y: " + this.getY() + "\n";
    }
}
