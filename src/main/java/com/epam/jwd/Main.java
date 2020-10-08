package com.epam.jwd;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String args[]) throws FigureException {


    }


    static Point[] CreateArrayOfPoints() {
        return new Point[]{new Point(4, 5),
                new Point(-3, 8),
                new Point(3, 6),
                new Point(2, 10),
                new Point(4, 11)};
    }
}

