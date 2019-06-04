package com.yuriizub.maxpalindromefinder.MaxPalindromeResolver;

import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReader;
import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReaderTxtFileToStrings;
import com.yuriizub.maxpalindromefinder.InputDataReaders.InputDataReaderTxtFileToWorlds;
import com.yuriizub.maxpalindromefinder.OutputDataWriters.OutputDataWriter;
import com.yuriizub.maxpalindromefinder.OutputDataWriters.OutputDataWriterToTxtFile;
import com.yuriizub.maxpalindromefinder.OutputDataWriters.OutputObjectPalindromeList;
import com.yuriizub.maxpalindromefinder.PalindromeFinder.PalindromeFinder;
import com.yuriizub.maxpalindromefinder.PalindromeFinder.PalindromeFinderByString;
import com.yuriizub.maxpalindromefinder.PalindromeFinder.PalindromeFinderByWorlds;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MaxPalindromeResolverFromFileToFile implements MaxPalindromeResolver {

    private InputDataReader inputFileReader;
    private PalindromeFinder palindromeFinder;
    private OutputDataWriter outputFileWriter;
    private InputParameters inputParameters;

    public MaxPalindromeResolverFromFileToFile() {
    }

    @Override
    public boolean resolveMaximalPalindrome(InputParameters inputParameters) throws IOException {
        this.inputParameters = inputParameters;
        switch (inputParameters.getResolvingType()) {
            case 0: {
                resolvingMaxPalindromeFromFileToFileWithWorlds();
            }
            break;
            case 1: {
                resolvingMaxPalindromeFromFileToFileWithStrings();
            }
            break;
            default: {
                resolvingMaxPalindromeFromFileToFileWithWorlds();
            }
        }
        return false;
    }

    private void resolvingMaxPalindromeFromFileToFileWithWorlds() throws IOException {
        inputFileReader = new InputDataReaderTxtFileToWorlds();
        List<String> inputList = inputFileReader.readData(this.inputParameters.getInputSourceAddress());

        palindromeFinder = new PalindromeFinderByWorlds();
        List<String> outputList = palindromeFinder.findPalindromes(inputList);

        outputList = processOnPalindromes(outputList);
        savePalindromes (outputList);
    }

    private void resolvingMaxPalindromeFromFileToFileWithStrings() throws IOException {
        inputFileReader = new InputDataReaderTxtFileToStrings();
        List<String> inputList = inputFileReader.readData(this.inputParameters.getInputSourceAddress());

        palindromeFinder = new PalindromeFinderByString();
        List<String> outputList = palindromeFinder.findPalindromes(inputList);

        outputList = processOnPalindromes(outputList);
        savePalindromes (outputList);

    }

    private List<String> getMaximalPalindromes(List<String> beforeList) {

        int longest = beforeList.stream()
                .mapToInt(String::length)
                .max()
                .orElse(-1);

        List<String> afterLits = beforeList.stream()
                .filter(s -> s.length() == longest)
                .collect(Collectors.toList());
        return afterLits;
    }

    private List<String> processOnPalindromes(List<String> outputList) {
        outputList = getMaximalPalindromes(outputList);
        outputList = getDistinctPalindromes(outputList);
        outputList = sortPalindromes(outputList);
        return outputList;
    }

    private void savePalindromes(List<String> outputList) {
        OutputObjectPalindromeList outputObject
                = new OutputObjectPalindromeList(this.inputParameters.getOutputSourceAddress(), outputList);
        outputFileWriter = new OutputDataWriterToTxtFile();
        outputFileWriter.writeOutputObject(outputObject);
    }

    private List<String> getDistinctPalindromes(List<String> beforeList) {
        List<String> afterList = beforeList.stream().distinct().collect(Collectors.toList());
        return afterList;
    }

    private List<String> sortPalindromes(List<String> beforeList) {

        List<String> aftertList = beforeList.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
        return aftertList;
    }

}
