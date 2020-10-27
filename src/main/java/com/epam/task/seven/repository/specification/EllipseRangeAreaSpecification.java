package com.epam.task.seven.repository.specification;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.logic.EllipseCalculator;

public class EllipseRangeAreaSpecification implements Specification {
    private final double minArea;
    private final double maxArea;
    private final EllipseCalculator calculator;

    public EllipseRangeAreaSpecification(double minArea, double maxArea, EllipseCalculator calculator) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(Ellipse ellipse) {
        double area = calculator.getArea(ellipse);
        return area >= minArea && area <= maxArea;
    }
}
