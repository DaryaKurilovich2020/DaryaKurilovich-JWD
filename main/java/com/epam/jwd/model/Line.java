package com.epam.jwd.model;

public class Line extends Figure {
    private Point point1;
    private Point point2;

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Line(String name, Point point1, Point point2) {
        super(name);
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "name: " + this.getName() + "\n" +
                "points: " + this.getPoint1().getName() + " " +
                this.getPoint2().getName();
    }
}
