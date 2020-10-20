package com.epam.task.seven.validator;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;
import org.junit.Assert;
import org.junit.Test;

public class EllipseValidatorTest {

    private static final Point FIRST_CORRECT_POINT = new Point(5.2, 1.9);
    private static final Point SECOND_CORRECT_POINT = new Point(-8.3, -3.7);
    private static final Point FIRST_INCORRECT_POINT = new Point(5.2, -1.9);
    private static final Point SECOND_INCORRECT_POINT = new Point(-8.3, 1.9);
    private static final Ellipse ACTUAL_COUPLE_POINT = new Ellipse(FIRST_CORRECT_POINT, SECOND_CORRECT_POINT);
    private static final Ellipse INCORRECT_COUPLE_POINT = new Ellipse(FIRST_CORRECT_POINT, FIRST_CORRECT_POINT);
    private static final Ellipse INCORRECT_X_COUPLE_POINT =
            new Ellipse(FIRST_CORRECT_POINT, FIRST_INCORRECT_POINT);
    private static final Ellipse INCORRECT_Y_COUPLE_POINT =
            new Ellipse(FIRST_CORRECT_POINT, SECOND_INCORRECT_POINT);

    @Test
    public void testIsValidShouldReturnTrueWhenConditionCreationIsCorrect() {
        //given
        EllipseValidator validator = new EllipseValidator();

        //when
        boolean expected = validator.isValid(ACTUAL_COUPLE_POINT);

        //then
        Assert.assertTrue(expected);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenConditionCreationIsNotCorrectPointsIsEqual() {
        //given
        EllipseValidator validator = new EllipseValidator();

        //when
        boolean expected = validator.isValid(INCORRECT_COUPLE_POINT);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenConditionCreationIsNotCorrectCoordinateXOfPointsIsEqual() {
        //given
        EllipseValidator validator = new EllipseValidator();

        //when
        boolean expected = validator.isValid(INCORRECT_X_COUPLE_POINT);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void testIsValidShouldReturnFalseWhenConditionCreationIsNotCorrectCoordinateYOfPointsIsEqual() {
        //given
        EllipseValidator validator = new EllipseValidator();

        //when
        boolean expected = validator.isValid(INCORRECT_Y_COUPLE_POINT);

        //then
        Assert.assertFalse(expected);
    }


}