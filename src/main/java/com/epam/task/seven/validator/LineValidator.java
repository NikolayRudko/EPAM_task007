package com.epam.task.seven.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineValidator {

    public static final String PATTERN = "^(-?\\d+\\.\\d+\\s+){3}-?\\d+\\.\\d+\\s*$";

    public boolean isValid(String line) {
        Pattern linePattern = Pattern.compile(PATTERN);
        Matcher matcher = linePattern.matcher(line);
        return matcher.matches();
    }
}
