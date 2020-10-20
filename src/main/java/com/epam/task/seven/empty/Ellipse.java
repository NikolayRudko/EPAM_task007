package com.epam.task.seven.empty;

import java.util.Objects;
import java.util.StringJoiner;

public class Ellipse {
    private Point pointFirst;
    private Point pointSecond;

    public Ellipse(Point pointFirst, Point pointSecond) {
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
    }

    public Point getPointFirst() {
        return pointFirst;
    }

    public void setPointFirst(Point pointFirst) {
        this.pointFirst = pointFirst;
    }

    public Point getPointSecond() {
        return pointSecond;
    }

    public void setPointSecond(Point pointSecond) {
        this.pointSecond = pointSecond;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Ellipse ellipse = (Ellipse) obj;

        if (!Objects.equals(pointFirst, ellipse.pointFirst)) {
            return false;
        }

        return Objects.equals(pointSecond, ellipse.pointSecond);
    }

    @Override
    public int hashCode() {
        int result = pointFirst != null ? pointFirst.hashCode() : 0;
        result = 31 * result + (pointSecond != null ? pointSecond.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ellipse.class.getSimpleName() + "[", "]")
                .add("pointFirst=" + pointFirst)
                .add("pointSecond=" + pointSecond)
                .toString();
    }
}
