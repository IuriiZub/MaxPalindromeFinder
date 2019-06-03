package com.yuriizub.maxpalindromefinder;

import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReader;
import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReaderTxtFileToWorlds;
import com.yuriizub.maxpalindromefinder.OutputDataWriters.OutputDataWriter;
import com.yuriizub.maxpalindromefinder.OutputDataWriters.OutputDataWriterToTxtFile;
import com.yuriizub.maxpalindromefinder.OutputDataWriters.OutputObjectPalindromeList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yurii on 6/3/2019.
 */
public class MainTest {
    @Test
    public void main() throws Exception {
        String[] args = null;
        args = new String[]{"inputtest1.txt", "outputtest1.txt", "false", "0", "0", "0"};

        List<String> inputList = new ArrayList();
        inputList.add("течет");
        inputList.add("лиШил");
        inputList.add("лишил , ");
        inputList.add("течет");
        inputList.add("Течет");
        inputList.add("Или");
        inputList.add(" ");
        inputList.add("колобок");
        inputList.add("33333333333333");

        OutputObjectPalindromeList outputObject = new OutputObjectPalindromeList(args[0], inputList);
        OutputDataWriter outputDataWriter = new OutputDataWriterToTxtFile();
        outputDataWriter.writeOutputObject(outputObject);

        List<String> expectedList = new ArrayList();
        expectedList.add("лишил");
        expectedList.add("течет");

        Main.main(args);

        InputDataReader inputDataReader = new InputDataReaderTxtFileToWorlds();
        List<String> actualList = inputDataReader.readData(args[1]);

        assertEquals(expectedList, actualList);
    }

}