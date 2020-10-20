package com.epam.task.seven.parser;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;

public class PointParser {

    public Ellipse parse(String lines) {

        String[] data = lines.split("\\s+");
        if (data.length != 4) {
            throw new IllegalArgumentException("String not in correct format");
        }

        double firstPointCoordinateX = Double.parseDouble(data[0]);
        double firstPointCoordinateY = Double.parseDouble(data[1]);
        double secondPointCoordinateX = Double.parseDouble(data[2]);
        double secondPointCoordinateY = Double.parseDouble(data[3]);

        Point firstPoint = new Point(firstPointCoordinateX, firstPointCoordinateY);
        Point secondPoint = new Point(secondPointCoordinateX, secondPointCoordinateY);
        return new Ellipse(firstPoint, secondPoint);
    }
}
