package com.epam.task.seven.parser;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;
import org.junit.Assert;
import org.junit.Test;

public class PointParserTest {
    private static final String ORIGIN_LINE = "0.1 0.2 -0.1 0.0";
    private static final String BROKEN_LINE = "0.1 d.2 -0.1 0.0";
    private static final Point FIRST_POINT = new Point(0.1, 0.2);
    private static final Point SECOND_POINT = new Point(-0.1, 0.0);
    private static final Ellipse ACTUAL_COUPLE_POINT = new Ellipse(FIRST_POINT, SECOND_POINT);

    @Test
    public void testParseShouldReturnCouplePointWhenLineIsCorrect() {
        //given
        PointParser parser = new PointParser();

        //when
        Ellipse expectedCouplePoint = parser.parse(ORIGIN_LINE);

        //then
        Assert.assertEquals(expectedCouplePoint, ACTUAL_COUPLE_POINT);
    }

    @Test(expected = NumberFormatException.class)
    public void testParseShouldThrowNumericFormatExceptionWhenLineIsNotCorrect() {
        //given
        PointParser parser = new PointParser();

        //when
        parser.parse(BROKEN_LINE);
    }
}