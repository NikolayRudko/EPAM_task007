package com.epam.task.seven.reader;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private final static String FILE_NAME = "src/test/resources/testDataFile.txt";
    private final static String TEST_ERROR_DATA = "src/test/resources/errorData.txt";
    private final static List<String> ACTUAL_DATA = Arrays.asList(
            "Test 1 test 1",
            "Test 2",
            "2");

    @Test
    public void testShouldReadLinesWhenFileExist() throws DataException {
        //given
        DataReader reader = new FileDataReader();

        //when
        List<String> expected = reader.readLines(FILE_NAME);

        //then
        Assert.assertEquals(expected, ACTUAL_DATA);
    }

    @Test(expected = DataException.class)
    public void testShouldThrowsDataExceptionWhenFileDoesNotExist() throws DataException {
        //given
        DataReader reader = new FileDataReader();

        //when
        reader.readLines(TEST_ERROR_DATA);
    }
}