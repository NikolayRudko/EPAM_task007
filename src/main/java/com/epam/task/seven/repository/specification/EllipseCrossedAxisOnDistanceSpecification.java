package com.epam.task.seven.repository.specification;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.logic.EllipseCalculator;

public class EllipseCrossedAxisOnDistanceSpecification implements Specification {

    private final double distance;
    private final EllipseCalculator calculator;

    public EllipseCrossedAxisOnDistanceSpecification(double distance, EllipseCalculator calculator) {
        this.distance = distance;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(Ellipse ellipse) {
        return calculator.isCrossesOneAxisOnDistance(ellipse, distance);
    }
}
