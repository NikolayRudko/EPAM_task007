package com.epam.task.seven.director;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.parser.PointParser;
import com.epam.task.seven.validator.EllipseValidator;

import java.util.Optional;

public class EllipseCreator {

    private final PointParser parser;
    private final EllipseValidator validator;

    public EllipseCreator(PointParser parser, EllipseValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public Optional<Ellipse> create(String line) {
        Ellipse ellipse = parser.parse(line);
        return validator.isValid(ellipse) ? Optional.of(ellipse) : Optional.empty();
    }
}
