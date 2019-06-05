package com.yuriizub.maxpalindromefinder;

import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReader;
import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReaderTxtFileToStrings;
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
    public void testWithWorldsReader() throws Exception{
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

    @Test
    public void testWithStringReader() throws Exception{

        String[] args = null;
        args = new String[]{"inputtest2.txt", "outputtest2.txt", "false", "1", "0", "0"};

        List<String> inputList = new ArrayList();
        inputList.add("кококо около миши молоко окококо окококо около миши молоко");
        inputList.add("У дуба буду");
        inputList.add("У дуба буду Дубай");
        inputList.add("Он рубил и потел от вина, холодно - он до лохани, в то лето пили бурно");
        inputList.add("Ты, милок, иди яром: у дороги мина, за дорогой огород, а за ним и город у моря; иди, коли мыт");
        inputList.add("Ты, милок, иди яром: у дороги мина, за дорогой огород, а за ним и город у моря; иди, коли мыт");
        inputList.add("Ну, ты, милок, иди яром: у дороги мина, за дорогой огород, а за ним и город у моря; иди, коли мыт");
        inputList.add("Ну, иди ты, милок, иди яром: у дороги мина, за дорогой огород, а за ним и город у моря; иди, коли мыт иди пешком");
        inputList.add("Ну, еле ты, милок, иди яром: у дороги мина, за дорогой огород, а за ним и город у моря; иди, коли мыт еле пешком");
        inputList.add("Ну, давай, еле ты, милок, иди яром: у дороги мина, за дорогой огород, а за ним и город у моря; иди, коли мыт еле пешком далеко далеко и медленно");
        inputList.add("Или");
        inputList.add(" ");
        inputList.add("колобок");
        inputList.add("33333333333333");

        OutputObjectPalindromeList outputObject = new OutputObjectPalindromeList(args[0], inputList);
        OutputDataWriter outputDataWriter = new OutputDataWriterToTxtFile();
        outputDataWriter.writeOutputObject(outputObject);

        List<String> expectedList = new ArrayList();
        expectedList.add("еле ты милок иди яром у дороги мина за дорогой огород а за ним и город у моря иди коли мыт еле");
        expectedList.add("иди ты милок иди яром у дороги мина за дорогой огород а за ним и город у моря иди коли мыт иди");

        Main.main(args);

        InputDataReader inputDataReader = new InputDataReaderTxtFileToStrings();
        List<String> actualList = inputDataReader.readData(args[1]);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testWithWorldsReaderEmpty() throws Exception{
        String[] args = null;
        args = new String[]{"inputtest4.txt", "outputtest4.txt", "false", "0", "0", "0"};

        List<String> inputList = new ArrayList();

        OutputObjectPalindromeList outputObject = new OutputObjectPalindromeList(args[0], inputList);
        OutputDataWriter outputDataWriter = new OutputDataWriterToTxtFile();
        outputDataWriter.writeOutputObject(outputObject);

        List<String> expectedList = new ArrayList();

        Main.main(args);

        InputDataReader inputDataReader = new InputDataReaderTxtFileToWorlds();
        List<String> actualList = inputDataReader.readData(args[1]);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testWithStringReaderEmpty() throws Exception{

        String[] args = null;
        args = new String[]{"inputtest3.txt", "outputtest3.txt", "false", "1", "0", "0"};

        List<String> inputList = new ArrayList();

        OutputObjectPalindromeList outputObject = new OutputObjectPalindromeList(args[0], inputList);
        OutputDataWriter outputDataWriter = new OutputDataWriterToTxtFile();
        outputDataWriter.writeOutputObject(outputObject);

        List<String> expectedList = new ArrayList();

        Main.main(args);

        InputDataReader inputDataReader = new InputDataReaderTxtFileToStrings();
        List<String> actualList = inputDataReader.readData(args[1]);

        assertEquals(expectedList, actualList);
    }


}