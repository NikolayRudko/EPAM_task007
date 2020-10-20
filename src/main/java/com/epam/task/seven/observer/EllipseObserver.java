package com.epam.task.seven.observer;

import com.epam.task.seven.logic.EllipseCalculator;

import java.util.HashMap;
import java.util.Map;

public class EllipseObserver implements Observer {
    private final Map<Integer, Parameters> ellipseParameters = new HashMap<>();
    private final EllipseCalculator calculator = new EllipseCalculator();
    private static final EllipseObserver INSTANCE = new EllipseObserver();

    private EllipseObserver() {
    }

    public static EllipseObserver getInstance() {
        return INSTANCE;
    }

    @Override
    public void update(EllipseObservable ellipse) {
        double area = calculator.getArea(ellipse);
        double perimeter = calculator.getPerimeter(ellipse);
        Parameters parameters = new Parameters(perimeter, area);
        Integer id = ellipse.getId();
        ellipseParameters.put(id, parameters);
    }
}
