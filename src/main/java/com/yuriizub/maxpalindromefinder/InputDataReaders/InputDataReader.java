package com.yuriizub.maxpalindromefinder.InputDataReaders;

import java.io.IOException;
import java.util.List;

public interface InputDataReader {
    List<String> readData(String sourceAddress) throws IOException;
}
