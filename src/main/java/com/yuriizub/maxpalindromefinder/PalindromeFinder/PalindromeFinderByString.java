package com.yuriizub.maxpalindromefinder.PalindromeFinder;

import java.util.ArrayList;
import java.util.List;

public class PalindromeFinderByString implements PalindromeFinder {
    @Override
    public List<String> findPalindromes(List<String> inputList) {
        List<String> outputList = new ArrayList();
        for (String inputString : inputList) {
            if (findMaxPalindromeInString(inputString) != "")
                outputList.add(findMaxPalindromeInString(inputString));
        }
        return outputList;
    }

    private String findMaxPalindromeInString(String beforeString) {
        beforeString = beforeString.replaceAll("\\s+", "");
        StringBuffer beforeStringBuffer = new StringBuffer(beforeString);
        StringBuffer afterStringBuffer = beforeStringBuffer.reverse();
        String resultString = "";
        for (int i = 0; i < beforeStringBuffer.length(); i++) {
            resultString = "";
            if (beforeStringBuffer.subSequence(i, beforeStringBuffer.length()-1) == afterStringBuffer.subSequence(0, afterStringBuffer.length()-1-i)) {
                resultString = beforeStringBuffer.toString();
                break;
            }
        }
        return resultString;
    }
}
