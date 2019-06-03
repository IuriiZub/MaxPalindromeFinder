package com.yuriizub.maxpalindromefinder.OutputDataWriters;

import java.util.List;

public class OutputObjectPalindromeList {

    private final String sourceAddress;
    private final List<String> outputList;

    public OutputObjectPalindromeList (String sourceAddress, List<String> outputList) {
        this.sourceAddress = sourceAddress;
        this.outputList = outputList;
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    public List<String> getOutputSource() {
        return this.outputList;
    }

}
