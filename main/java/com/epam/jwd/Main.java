package com.epam.jwd;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;
import com.epam.jwd.model.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String args[]) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        Point[] points = CreateArrayOfPoints();
        Line[] lines = CreateArrayOfLines();
        Triangle[] triangles = CreateArrayOfTriangles();
        Square[] squares = CreateArrayOfSquares();

        int i = 0;
        do {
            logger.info("Info about points " + points[i].toString());
        }
        while (++i < 4);
        for (int j = 0; j < lines.length; j++) {
            logger.info("Info about lines " + lines[j].toString());
        }
        for (int k = 0; k < triangles.length; k++) {
            logger.info("Info about triangles " + triangles[k].toString());
        }
        for (int u = 0; u < squares.length; u++) {
            logger.info("Info about squares " + squares[u].toString());
        }

    }


    static Point[] CreateArrayOfPoints() {
        return new Point[]{new Point("point1", 4, 5),
                new Point("point2", -3, 8),
                new Point("point3", 3, 6),
                new Point("point4", 2, 10)};
    }

    static Line[] CreateArrayOfLines() {
        return new Line[]{new Line("line1", new Point("p1", 3, 8), new Point("p2", 5, 7)),
                new Line("line2", new Point("p3", 2, -10), new Point("p4", 7, 9))};

    }

    static Triangle[] CreateArrayOfTriangles() {
        return new Triangle[]{
                new Triangle("triangle1", new Line("a", new Point("p1", 3, 8), new Point("p2", 5, 7)),
                        new Line("b", new Point("p3", 2, -10), new Point("p4", 7, 10)),
                        new Line("c", new Point("p5", 12, -1), new Point("p6", -7, 9))),
                new Triangle("triangle2", new Line("a1", new Point("p7", 2, 8), new Point("p8", 5, 7)),
                        new Line("b1", new Point("p9", 2, -10), new Point("p10", -6, 9)),
                        new Line("c1", new Point("p11", 12, -1), new Point("p12", 5, 17)))};
    }

    static Square[] CreateArrayOfSquares() {
        return new Square[]{new Square("square", new Line("ab", new Point("", 1, 2), new Point("", 1, 8)),
                new Line("bc", new Point("", 1, 8), new Point("", 7, 8)),
                new Line("cd", new Point("", 7, 8), new Point("", 7, 2)),
                new Line("da", new Point("", 7, 8), new Point("", 1, 2)))};
    }
}

