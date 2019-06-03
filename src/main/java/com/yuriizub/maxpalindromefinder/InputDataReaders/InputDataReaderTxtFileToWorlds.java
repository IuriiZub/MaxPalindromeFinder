package com.yuriizub.maxpalindromefinder.InputDataReaders;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputDataReaderTxtFileToWorlds implements InputDataReader{
    @Override
    public List<String> readData(String sourceAddress) throws IOException {
        File inputFile = new File(sourceAddress);
        List<String> myList = new ArrayList();
        myList = Files.lines(Paths.get(inputFile.getAbsolutePath()))
                .flatMap(s -> Stream.of(s.split(" ")))
                .map(s -> s.toLowerCase())
                .map(s -> s.replaceAll("[^a-zA-Zа-яА-Я]", ""))
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
        return myList;
    }
}
