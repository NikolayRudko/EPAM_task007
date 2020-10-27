package com.epam.task.seven.director;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.validator.LineValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Director {
    private final static Logger LOGGER = Logger.getLogger(Director.class);

    private final EllipseCreator ellipseCreator;
    private final LineValidator validator;

    public Director(EllipseCreator ellipseCreator, LineValidator validator) {
        this.ellipseCreator = ellipseCreator;
        this.validator = validator;
    }

    public List<Ellipse> create(List<String> lineList) {
        List<Ellipse> ellipseList = new ArrayList<>();

        for (String line : lineList) {
            if (validator.isValid(line)) {
                Optional<Ellipse> ellipse = ellipseCreator.create(line);
                if (ellipse.isPresent()) {
                    ellipseList.add(ellipse.get());
                } else {
                    LOGGER.warn(String.format("Incorrect data.%nThis line cannot be converted in the CouplePoint:%n%s", line));
                }
            } else {
                LOGGER.warn(String.format("Incorrect format of line.%nThis line cannot be converted in the CouplePoint:%n%s", line));
            }
        }

        return ellipseList;
    }
}
