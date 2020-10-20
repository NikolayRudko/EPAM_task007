package com.epam.task.seven.logic.comparator;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;

import java.util.Comparator;

public class EllipseSecondPointYComparator implements Comparator<Ellipse> {
    @Override
    public int compare(Ellipse firstEllipse, Ellipse secondEllipse) {
        Point first = firstEllipse.getPointSecond();
        Point second = secondEllipse.getPointSecond();
        double firstPointCoordinateY = first.getCoordinateY();
        double secondPointCoordinateY = second.getCoordinateY();
        return Double.compare(firstPointCoordinateY, secondPointCoordinateY);
    }
}
