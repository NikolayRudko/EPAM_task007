package com.epam.task.seven.logic;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;

public class EllipseCalculator {
    public double getArea(Ellipse ellipse) {
        return Math.PI * getSemiAxisCoordinateX(ellipse) * getSemiAxisCoordinateY(ellipse);
    }

    public double getPerimeter(Ellipse ellipse) {
        double semiAxisA = getSemiAxisCoordinateX(ellipse);
        double semiAxisB = getSemiAxisCoordinateY(ellipse);

        return 4 * (Math.PI * semiAxisA * semiAxisB + Math.pow(semiAxisA - semiAxisB, 2)) / (semiAxisA + semiAxisB);
    }

    public boolean isCycle(Ellipse ellipse) {
        return getSemiAxisCoordinateX(ellipse) == getSemiAxisCoordinateY(ellipse);
    }

    public boolean isEllipse(Ellipse ellipse) {
        return getSemiAxisCoordinateX(ellipse) != getSemiAxisCoordinateY(ellipse);
    }

    public boolean isCrossesOneAxisOnDistance(Ellipse ellipse, double distance) {

        if (isCrossesOneAxisX(ellipse) && isCrossesOneAxisY(ellipse)) {
            return false;
        }

        return (isCrossesOneAxisX(ellipse) || isCrossesOneAxisY(ellipse)) &&
                (getDistanceCrossesByAxisX(ellipse) >= distance || getDistanceCrossesByAxisY(ellipse) >= distance);
    }

    private double getDistanceCrossesByAxisX(Ellipse ellipse) {

        if (!isCrossesOneAxisX(ellipse)) {
            return -1;
        }

        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return Math.max(Math.abs(firstPoint.getCoordinateX()), Math.abs(secondPoint.getCoordinateX()));
    }

    private double getDistanceCrossesByAxisY(Ellipse ellipse) {

        if (!isCrossesOneAxisY(ellipse)) {
            return -1;
        }

        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return Math.max(Math.abs(firstPoint.getCoordinateY()), Math.abs(secondPoint.getCoordinateY()));
    }

    private boolean isCrossesOneAxisX(Ellipse ellipse) {
        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return firstPoint.getCoordinateX() > 0 && secondPoint.getCoordinateX() < 0 ||
                firstPoint.getCoordinateX() < 0 && secondPoint.getCoordinateX() > 0;
    }

    private boolean isCrossesOneAxisY(Ellipse ellipse) {
        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return firstPoint.getCoordinateY() > 0 && secondPoint.getCoordinateY() < 0 ||
                firstPoint.getCoordinateY() < 0 && secondPoint.getCoordinateY() > 0;
    }

    private double getSemiAxisCoordinateX(Ellipse ellipse) {
        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return Math.abs(firstPoint.getCoordinateX() - secondPoint.getCoordinateX()) / 2;
    }

    private double getSemiAxisCoordinateY(Ellipse ellipse) {
        Point firstPoint = ellipse.getPointFirst();
        Point secondPoint = ellipse.getPointSecond();

        return Math.abs(firstPoint.getCoordinateY() - secondPoint.getCoordinateY()) / 2;
    }
}
