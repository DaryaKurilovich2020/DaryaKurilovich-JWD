package com.epam.jwd;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.*;
import jdk.dynalink.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws FigureException {
        Operation op = (int a, int b) -> a > 5 ? a - b : a + b;
    }

    interface Operation {
        int calculate(int a, int b);
    }

    static Point[] CreateArrayOfPoints() {
        return new Point[]{new Point(4, 5),
                new Point(-3, 8),
                new Point(3, 6),
                new Point(2, 10),
                new Point(4, 11)};
    }
}

