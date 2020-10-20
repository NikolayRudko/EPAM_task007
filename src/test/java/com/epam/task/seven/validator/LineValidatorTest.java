package com.epam.task.seven.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineValidatorTest {

    private static final String CORRECT_LINE = "0.0 -1.2 1111.0 0.15151515";
    private static final String INCORRECT_LINE_FIRST = ".0 0.2 0.0 0.1";
    private static final String INCORRECT_LINE_SECOND = "0.0 1 0.0 0.1";
    private static final String INCORRECT_LINE_THIRD = "f.0 0.2 0.0 0.1";

    @Test
    public void TestIsValidShouldReturnTrueWhenLineIsCorrect() {
        //given
        LineValidator validator = new LineValidator();

        //when
        boolean expected = validator.isValid(CORRECT_LINE);

        //then
        Assert.assertTrue(expected);
    }

    @Test
    public void TestIsValidShouldReturnFalseWhenLineConsiderIncorrectFractionalNumberFormat() {
        //given
        LineValidator validator = new LineValidator();

        //when
        boolean expected = validator.isValid(INCORRECT_LINE_FIRST);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void TestIsValidShouldReturnFalseWhenLineConsiderIncorrectIntegerPartNumberFormat() {
        //given
        LineValidator validator = new LineValidator();

        //when
        boolean expected = validator.isValid(INCORRECT_LINE_SECOND);

        //then
        Assert.assertFalse(expected);
    }

  @Test
    public void TestIsValidShouldReturnFalseWhenLineConsiderIncorrectChar() {
        //given
        LineValidator validator = new LineValidator();

        //when
        boolean expected = validator.isValid(INCORRECT_LINE_THIRD);

        //then
        Assert.assertFalse(expected);
    }
}