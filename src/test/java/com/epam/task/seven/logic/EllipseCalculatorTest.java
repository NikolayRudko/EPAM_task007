package com.epam.task.seven.logic;

import com.epam.task.seven.empty.Ellipse;
import com.epam.task.seven.empty.Point;
import org.junit.Assert;
import org.junit.Test;

public class EllipseCalculatorTest {

    private static final Point FIRST_POINT = new Point(2, 2);
    private static final Point SECOND_POINT = new Point(-4, -2);
    private static final Point THIRD_POINT = new Point(-2, -2);
    private static final Point FOUR_POINT = new Point(-8, 2);
    private static final Point FIVE_POINT = new Point(-8, 4);

    private static final Ellipse ELLIPSE = new Ellipse(FIRST_POINT, SECOND_POINT);
    private static final Ellipse CYCLE = new Ellipse(FIRST_POINT, THIRD_POINT);
    private static final double DELTA = 0.001;
    private static final double ACTUAL_AREA = 18.849;
    private static final double ACTUAL_PERIMETER = 15.879;

    private static final Ellipse ELLIPSE_CROSSES_AXIS_X = new Ellipse(THIRD_POINT, FOUR_POINT);
    private static final Ellipse ELLIPSE_CROSSES_AXIS_Y = new Ellipse(FIRST_POINT, FIVE_POINT);
    private static final Ellipse ELLIPSE_CROSSES_TWO_AXIS= new Ellipse(FIRST_POINT, SECOND_POINT);
    private static final double DISTANCE = 2;
    private static final double DISTANCE_FAIL = 10;

    @Test
    public void testShouldCalculateAreaEclipse() {
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        double expected = calculator.getArea(ELLIPSE);

        //then
        Assert.assertEquals(expected, ACTUAL_AREA, DELTA);
    }

    @Test
    public void testShouldCalculatePerimeterEclipse() {
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        double expected = calculator.getPerimeter(ELLIPSE);

        //then
        Assert.assertEquals(expected, ACTUAL_PERIMETER, DELTA);
    }

    @Test
    public void testShouldReturnTrueIfIsCycle(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCycle(CYCLE);

        //then
        Assert.assertTrue(expected);
    }

    @Test
    public void testShouldReturnFalseIfIsNotCycle(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCycle(ELLIPSE);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void testShouldReturnTrueIfIsEllipse(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isEllipse(ELLIPSE);

        //then
        Assert.assertTrue(expected);
    }

    @Test
    public void testShouldReturnFalseIfIsNotEllipse(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isEllipse(CYCLE);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void testShouldReturnTrueIfEllipseCrossesOnlyAxisXOnDistance(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCrossesOneAxisOnDistance(ELLIPSE_CROSSES_AXIS_X, DISTANCE);

        //then
        Assert.assertTrue(expected);
    }

    @Test
    public void testShouldReturnFalseIfEllipseDoesNotCrossesOnlyAxisXOnDistance(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCrossesOneAxisOnDistance(ELLIPSE_CROSSES_AXIS_X, DISTANCE_FAIL);

        //then
        Assert.assertFalse(expected);
    }
    @Test
    public void testShouldReturnTrueIfEllipseCrossesOnlyAxisYOnDistance(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCrossesOneAxisOnDistance(ELLIPSE_CROSSES_AXIS_Y, DISTANCE);

        //then
        Assert.assertTrue(expected);
    }

    @Test
    public void testShouldReturnFalseIfEllipseDoesNotCrossesOnlyAxisYOnDistance(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCrossesOneAxisOnDistance(ELLIPSE_CROSSES_AXIS_Y, DISTANCE_FAIL);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void testShouldReturnFalseIfEllipseCrossesTwoAxisesYOnDistance(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCrossesOneAxisOnDistance(ELLIPSE_CROSSES_TWO_AXIS, DISTANCE);

        //then
        Assert.assertFalse(expected);
    }

    @Test
    public void testShouldReturnFalseIfEllipseDoesNotCrossesTwoAxisesOnDistance(){
        //given
        EllipseCalculator calculator = new EllipseCalculator();

        //when
        boolean expected = calculator.isCrossesOneAxisOnDistance(ELLIPSE_CROSSES_TWO_AXIS, DISTANCE);

        //then
        Assert.assertFalse(expected);
    }
}