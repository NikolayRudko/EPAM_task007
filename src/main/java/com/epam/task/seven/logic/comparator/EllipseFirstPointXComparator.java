package com.epam.task.seven.logic.comparator;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;

import java.util.Comparator;

public class EllipseFirstPointXComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse firstEllipse, Ellipse secondEllipse) {
        Point first = firstEllipse.getPointFirst();
        Point second = secondEllipse.getPointFirst();
        double firstPointCoordinateX = first.getCoordinateX();
        double secondPointCoordinateX = second.getCoordinateX();
        return Double.compare(firstPointCoordinateX, secondPointCoordinateX);
    }
}
