package com.epam.task.seven.validator;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;

public class EllipseValidator {
    public boolean isValid(Ellipse ellipse) {
        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return !firstPoint.equals(secondPoint) &&
                firstPoint.getCoordinateX() != secondPoint.getCoordinateX() &&
                firstPoint.getCoordinateY() != secondPoint.getCoordinateY();
    }
}
