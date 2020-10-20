package com.epam.task.seven.empty;

import java.util.StringJoiner;

public class Point {
    private double coordinateX;
    private double coordinateY;

    public Point(double coordinateX, double coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public double getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public double getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(double coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point point = (Point) obj;

        if (Double.compare(point.coordinateX, coordinateX) != 0) {
            return false;
        }
        return Double.compare(point.coordinateY, coordinateY) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        // TODO: 13.10.2020
        temp = Double.doubleToLongBits(coordinateX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordinateY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("coordinateX=" + coordinateX)
                .add("coordinateY=" + coordinateY)
                .toString();
    }
}

