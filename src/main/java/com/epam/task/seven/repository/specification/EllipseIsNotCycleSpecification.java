package com.epam.task.seven.repository.specification;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.logic.EllipseCalculator;

public class EllipseIsNotCycleSpecification implements Specification {
    private final EllipseCalculator calculator;

    public EllipseIsNotCycleSpecification(EllipseCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public boolean specified(Ellipse ellipse) {
        return !calculator.isCycle(ellipse);
    }
}
