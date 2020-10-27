package com.epam.task.seven.director;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;
import com.epam.task.seven.parser.PointParser;
import com.epam.task.seven.validator.EllipseValidator;
import com.epam.task.seven.validator.LineValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {

     private final static List<String> CORRECT_LIST = Arrays.asList(
            "0.1 0.2 4.2 0.1",
            "0.4 0.2 0.2 0.6",
            "0.1 -0.2 12.2 0.1",
            "1.1 0.2 8.2 0.1",
            "0.1 0.2 0.2 0.1"
    );

    private final static List<String> INCORRECT_LIST = Arrays.asList(
            "0.1 0.2 4.2 0.1",
            "0.4 0.2 0.4 0.2",
            "0.1 -0.2 12.2 -0.2",
            "1.1 0.2 1.1 0.1",
            "0.1 0.2 0.2 0.1"
    );

    private final static int ACTUAL_SIZE_CORRECT_LIST = 5;
    private final static int ACTUAL_SIZE_INCORRECT_LIST = 2;

    private final PointParser pointParser = new PointParser();
    private final EllipseValidator ellipseValidator = new EllipseValidator();
    private final EllipseCreator ELLIPSE_CREATOR = new EllipseCreator(pointParser,ellipseValidator);
    private final LineValidator LINE_VALIDATOR = new LineValidator();

    @Test
    public void testCreateShouldCreateListEllipseSizeEqualListCouplePointWhenAllCouplePointsIsCorrect() {
        //given
        Director director = new Director(ELLIPSE_CREATOR, LINE_VALIDATOR);

        //when
        List<Ellipse> ellipseList = director.create(CORRECT_LIST);

        //then
        int expected_size = ellipseList.size();
        Assert.assertEquals(expected_size, ACTUAL_SIZE_CORRECT_LIST);
    }

    @Test
    public void testCreateShouldCreateListEllipseSizeEqualCountCorrectCouplePointWhenFewCouplePointsIsNotCorrect() {
        //given
        Director director = new Director(ELLIPSE_CREATOR, LINE_VALIDATOR);

        //when
        List<Ellipse> ellipseList = director.create(INCORRECT_LIST);

        //then
        int expected_size = ellipseList.size();
        Assert.assertEquals(expected_size, ACTUAL_SIZE_INCORRECT_LIST);
    }
}