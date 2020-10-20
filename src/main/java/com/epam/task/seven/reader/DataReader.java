package com.epam.task.seven.reader;

import java.util.List;

public interface DataReader {
    List<String> readLines(String fileName) throws DataException;
}
