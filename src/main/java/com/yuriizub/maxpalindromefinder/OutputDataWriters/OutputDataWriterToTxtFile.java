package com.yuriizub.maxpalindromefinder.OutputDataWriters;

import java.io.FileWriter;
import java.io.IOException;

public class OutputDataWriterToTxtFile implements  OutputDataWriter{

    @Override
    public boolean writeOutputObject(OutputObjectPalindromeList outputObjectPalindrome) {

        try(FileWriter writer = new FileWriter(outputObjectPalindrome.getSourceAddress()) ) {
            for(String outString : outputObjectPalindrome.getOutputSource()){
                writer.write(outString + System.getProperty("line.separator"));
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
